package fun.elricboa.spring.ioc.context;

import fun.elricboa.spring.ioc.BeanDefinition;
import fun.elricboa.spring.ioc.factory.AbstractBeanFactory;
import fun.elricboa.spring.ioc.factory.AutowireCapableBeanFactory;
import fun.elricboa.spring.ioc.io.ResourceLoader;
import fun.elricboa.spring.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author elricboa on 2018/2/9.
 */
public class XmlClassPathApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public XmlClassPathApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public XmlClassPathApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation);
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
