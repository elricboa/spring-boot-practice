package fun.elricboa.spring.ioc.factory;

import com.google.common.collect.Maps;
import fun.elricboa.spring.ioc.BeanDefinition;

import java.util.Map;

/**
 * @author elricboa on 2017/12/10.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = Maps.newConcurrentMap();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public Object registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        return beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
