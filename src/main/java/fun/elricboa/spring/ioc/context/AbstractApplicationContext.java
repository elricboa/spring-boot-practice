package fun.elricboa.spring.ioc.context;

import fun.elricboa.spring.ioc.factory.AbstractBeanFactory;

/**
 * @author elricboa on 2018/2/9.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    AbstractApplicationContext(AbstractBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
