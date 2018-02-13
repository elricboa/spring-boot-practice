package fun.elricboa.spring.ioc.beans;

import lombok.Data;

/**
 * @author elricboa on 2018/2/9.
 */
@Data
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }
}
