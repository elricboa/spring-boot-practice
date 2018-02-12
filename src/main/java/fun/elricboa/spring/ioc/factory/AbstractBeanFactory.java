package fun.elricboa.spring.ioc.factory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fun.elricboa.spring.ioc.beans.BeanDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author elricboa on 2017/12/10.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = Maps.newConcurrentMap();

    private final List<String> beanDefinitionNames = Lists.newArrayList();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("there is no bean name" + name + "is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionNames.add(name);
        beanDefinitionMap.put(name, beanDefinition);
    }

    public void initLazyBean() throws Exception {
        Iterator it = beanDefinitionNames.iterator();
        while (it.hasNext()) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }


    /**
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
