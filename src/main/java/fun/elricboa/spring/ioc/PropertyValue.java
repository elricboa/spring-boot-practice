package fun.elricboa.spring.ioc;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author elricboa on 2017/12/10.
 */
@AllArgsConstructor
@Getter
public class PropertyValue {
    private final String name;
    private final Object value;
}
