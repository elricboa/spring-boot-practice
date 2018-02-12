package fun.elricboa.spring.ioc.beans;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author elricboa on 2017/12/10.
 */
@NoArgsConstructor
public class PropertyValues {
    @Getter
    private final List<PropertyValue> propertyValueList = Lists.newArrayList();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

}
