package fun.elricboa.spring.ioc;

import lombok.Setter;

/**
 * @author elricboa on 2017/12/10.
 */
public class HelloSpringIOCService {
    @Setter
    private String text;

    void helloSpring() {
        System.out.println(text);
    }

}
