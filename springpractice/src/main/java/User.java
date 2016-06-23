import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shentongzhou on 16/6/6
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;

    @Override
    public String toString(){
        return String.format("User[id=%d,name=%s]",id,name);
    }
}
