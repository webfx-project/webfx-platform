package emul.java.net;

import java.net.MalformedURLException;

/**
 * Very minimalist support of URL class. GWT & WebFX don't support URL in general, the only usage so far is with the
 * FXML emulation, because a URL is required in the FXMLLoader constructor. But for this emulation, we just need to get
 * the URL path, so that's the only method we implement here.
 *
 * @author Bruno Salmon
 */
public class URL {

    private final String path;

    public URL(String path) throws MalformedURLException {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
