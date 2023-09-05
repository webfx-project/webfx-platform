package dev.webfx.platform.blob.spi.impl.gwt;

import dev.webfx.platform.blob.Blob;
import elemental2.dom.URL;

/**
 * @author Bruno Salmon
 */
public class GwtBlob implements Blob {

    private final elemental2.dom.Blob jsBlob;
    private String url;

    public GwtBlob(elemental2.dom.Blob jsBlob) {
        this.jsBlob = jsBlob;
    }

    @Override
    public elemental2.dom.Blob getPlatformBlob() {
        return jsBlob;
    }

    @Override
    public long length() {
        return jsBlob.size;
    }

    @Override
    public String getMimeType() {
        return jsBlob.type;
    }

    @Override
    public String getObjectURL() {
        if (url == null)
            url = URL.createObjectURL(jsBlob);
        return url;
    }
}
