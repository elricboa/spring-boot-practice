package fun.elricboa.spring.ioc.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author elricboa on 2018/2/12.
 */
@AllArgsConstructor
@Getter
public class TargetSource {
    private Class targetClass;
    private Object target;
}
