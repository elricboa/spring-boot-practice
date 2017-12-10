package fun.elricboa.spring.ioc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author elricboa on 2017/12/10.
 */

public class BeanDefinition {

    @Getter
    @Setter
    private Object bean;
    @Getter
    @Setter
    private Class beanClass;
    @Getter
    private String beanClassName;
    @Getter
    @Setter
    private PropertyValues propertyValues;

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
