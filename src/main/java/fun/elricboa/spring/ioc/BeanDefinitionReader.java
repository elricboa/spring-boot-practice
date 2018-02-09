package fun.elricboa.spring.ioc;

/**
 * @author elricboa on 2017/12/10.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
