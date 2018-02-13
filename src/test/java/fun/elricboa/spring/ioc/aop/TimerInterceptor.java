package fun.elricboa.spring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author elricboa on 2018/2/12.
 */
public class TimerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation Before Method" + methodInvocation.getMethod().getName() + "start");
        Object proceed = methodInvocation.proceed();
        System.out.println("Invocation After Method" + methodInvocation.getMethod().getName() + "end! take" + (System.nanoTime() - time) + "nanoSeconds");
        return proceed;
    }
}
