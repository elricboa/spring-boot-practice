package fun.elricboa.spring.ioc.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author elricboa on 2017/12/10.
 */

@NoArgsConstructor
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
    private PropertyValues propertyValues = new PropertyValues();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
