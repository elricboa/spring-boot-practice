package fun.elricboa.spring.ioc.aop;

import fun.elricboa.spring.ioc.HelloSpringIOCService;
import fun.elricboa.spring.ioc.context.ApplicationContext;
import fun.elricboa.spring.ioc.context.XmlClassPathApplicationContext;
import org.junit.Test;

/**
 * @author elricboa on 2018/2/12.
 */
public class JdkDynamicProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new XmlClassPathApplicationContext("springioc.xml");
        HelloSpringIOCService helloSpringIOCService = (HelloSpringIOCService) applicationContext.getBean("helloSpringIOCService");
        helloSpringIOCService.helloSpring();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloSpringIOCService.class, helloSpringIOCService);
        advisedSupport.setTargetSource(targetSource);

        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(advisedSupport);
        HelloSpringIOCService proxy = (HelloSpringIOCService) jdkDynamicProxy.getProxy();
        proxy.helloSpring();

    }

}
