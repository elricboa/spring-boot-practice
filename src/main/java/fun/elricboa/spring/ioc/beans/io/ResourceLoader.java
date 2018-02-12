package fun.elricboa.spring.ioc.beans.io;

import java.net.URL;

/**
 * @author elricboa on 2017/12/10.
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
