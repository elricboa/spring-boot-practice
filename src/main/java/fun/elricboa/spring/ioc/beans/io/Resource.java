package fun.elricboa.spring.ioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author elricboa on 2017/12/10.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
