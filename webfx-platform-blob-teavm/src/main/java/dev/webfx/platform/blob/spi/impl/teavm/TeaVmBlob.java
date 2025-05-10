package dev.webfx.platform.blob.spi.impl.teavm;

import dev.webfx.platform.blob.Blob;
import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public class TeaVmBlob implements Blob {

    private final org.teavm.jso.file.Blob jsBlob;
    private String url;

    public TeaVmBlob(org.teavm.jso.file.Blob jsBlob) {
        this.jsBlob = jsBlob;
    }

    @Override
    public org.teavm.jso.file.Blob getPlatformBlob() {
        return jsBlob;
    }

    @Override
    public long length() {
        return jsBlob.getSize();
    }

    @Override
    public String getMimeType() {
        return jsBlob.getType();
    }

    @Override
    public String getObjectURL() {
        if (url == null)
            url = createObjectURL(jsBlob);
        return url;
    }

    @JSBody(params = { "blob" }, script = "return URL.createObjectURL(blob);")
    public static native String createObjectURL(org.teavm.jso.file.Blob blob);

}