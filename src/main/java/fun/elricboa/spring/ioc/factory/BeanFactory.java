package fun.elricboa.spring.ioc.factory;

import fun.elricboa.spring.ioc.BeanDefinition;

/**
 * @author elricboa on 2017/12/10.
 */
public interface BeanFactory {

    Object getBean(String name);

    Object registerBeanDefinition(String name, BeanDefinition bean);
}
