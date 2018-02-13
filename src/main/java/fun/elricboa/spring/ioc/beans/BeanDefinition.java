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
    private PropertyValues propertyValues = new PropertyValues();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
