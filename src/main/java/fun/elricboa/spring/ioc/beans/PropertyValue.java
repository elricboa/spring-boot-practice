package fun.elricboa.spring.ioc.beans;

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

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
