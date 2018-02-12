package fun.elricboa.spring.ioc.context;

import fun.elricboa.spring.ioc.HelloSpringIOCService;
import org.junit.Test;

/**
 * @author elricboa on 2018/2/11.
 */
public class ApplicationContextTest {
    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext applicationContext = new XmlClassPathApplicationContext("springioc.xml");
        HelloSpringIOCService helloSpringIOCService = (HelloSpringIOCService) applicationContext.getBean("helloSpringIOCService");
        helloSpringIOCService.helloSpring();
    }
}
