package fun.elricboa.spring.ioc.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author elricboa on 2018/2/12.
 */
@Data
public class AdvisedSupport {
    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;
}
