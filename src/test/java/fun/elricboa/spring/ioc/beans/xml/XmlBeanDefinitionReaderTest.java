package fun.elricboa.spring.ioc.beans.xml;

import fun.elricboa.spring.ioc.beans.BeanDefinition;
import fun.elricboa.spring.ioc.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author elricboa on 2017/12/22.
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("springioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }

}
