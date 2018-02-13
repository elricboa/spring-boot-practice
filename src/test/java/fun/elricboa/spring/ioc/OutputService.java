package fun.elricboa.spring.ioc;

import lombok.Setter;
import org.junit.Assert;

/**
 * @author elricboa on 2018/2/11.
 */
public class OutputService {
    private HelloSpringIOCService helloSpringIOCService;

    public void output(String text) {
        Assert.assertNotNull(helloSpringIOCService);
        System.out.print(text);
    }

    public void setHelloSpringIOCService(HelloSpringIOCService helloWorldService) {
        this.helloSpringIOCService = helloWorldService;
    }
}
