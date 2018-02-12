package fun.elricboa.spring.ioc.factory;

import fun.elricboa.spring.ioc.beans.BeanDefinition;
import fun.elricboa.spring.ioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author elricboa on 2017/12/10.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        return beanDefinition.getBeanClass().newInstance();
    }
}
