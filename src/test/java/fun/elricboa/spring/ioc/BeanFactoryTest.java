package fun.elricboa.spring.ioc;

import fun.elricboa.spring.ioc.factory.AbstractBeanFactory;
import fun.elricboa.spring.ioc.factory.AutowireCapableBeanFactory;
import fun.elricboa.spring.ioc.factory.BeanFactory;
import fun.elricboa.spring.ioc.io.ResourceLoader;
import fun.elricboa.spring.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author elricboa on 2017/12/10.
 */
public class BeanFactoryTest {

    @Test
    public void testIOC() throws Exception {
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

    @Test
    public void testXMLBeanRegister() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("springioc.xml");
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        HelloSpringIOCService helloSpringIOCService = (HelloSpringIOCService) beanFactory.getBean("helloSpringIOCService");
        helloSpringIOCService.helloSpring();
    }

    @Test
    public void testLazyInitBean() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("springioc.xml");
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        beanFactory.initLazyBean();
        HelloSpringIOCService helloSpringIOCService = (HelloSpringIOCService) beanFactory.getBean("helloSpringIOCService");
        helloSpringIOCService.helloSpring();
    }

}
