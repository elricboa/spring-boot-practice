package fun.elricboa.spring.ioc.factory;

import lombok.Data;

/**
 * @author elricboa on 2018/2/9.
 */
@Data
class BeanReference {
    private String name;
    private Object bean;
}
