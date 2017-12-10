package fun.elricboa.spring.ioc;

import fun.elricboa.spring.ioc.factory.AutowireCapableBeanFactory;
import fun.elricboa.spring.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author elricboa on 2017/12/10.
 */
public class BeanFactoryTest {

    @Test
    public void testIOC() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("fun.elricboa.spring.ioc.HelloSpringIOCService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello Spring IOC"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloSpringIOCService", beanDefinition);

        HelloSpringIOCService helloSpringIOCService = (HelloSpringIOCService) beanFactory.getBean("helloSpringIOCService");
        helloSpringIOCService.helloSpring();
    }

}
