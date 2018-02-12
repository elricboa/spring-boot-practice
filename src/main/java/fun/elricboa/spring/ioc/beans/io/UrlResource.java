package fun.elricboa.spring.ioc.beans.io;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author elricboa on 2017/12/10.
 */
@AllArgsConstructor
public class UrlResource implements Resource {
    private final URL url;

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
