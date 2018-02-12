package fun.elricboa.spring.ioc.factory;

/**
 * @author elricboa on 2017/12/10.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
