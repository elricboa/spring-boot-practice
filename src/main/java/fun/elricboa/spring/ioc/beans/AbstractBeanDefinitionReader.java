package fun.elricboa.spring.ioc.beans;

import com.google.common.collect.Maps;
import fun.elricboa.spring.ioc.beans.io.ResourceLoader;
import lombok.Getter;

import java.util.Map;

/**
 * @author elricboa on 2017/12/10.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private Map<String, BeanDefinition> registry;

    @Getter
    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = Maps.newConcurrentMap();
        this.resourceLoader = resourceLoader;
    }
}
