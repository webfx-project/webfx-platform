package dev.webfx.platform.blob.spi.impl.teavm;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.BlobProvider;
import org.teavm.jso.browser.Window;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSString;
import org.teavm.jso.dom.html.HTMLAnchorElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.file.BlobPropertyBag;

/**
 * @author Bruno Salmon
 */
public final class TeaVmBlobProvider implements BlobProvider {

    @Override
    public Blob createBlob(Object platformBlob) {
        return new TeaVmBlob((org.teavm.jso.file.Blob) platformBlob);
    }

    @Override
    public Blob createTextBlob(String text) {
        // Create a Blob with the text content
        JSArray<JSString> parts = JSArray.of(JSString.valueOf(text));
        BlobPropertyBag options = BlobPropertyBag.create();
        options.type("text/plain");
        return new TeaVmBlob(new org.teavm.jso.file.Blob(parts, options));
    }

    @Override
    public void downloadUrl(String url, String fileName) {
        HTMLDocument document = Window.current().getDocument();
        HTMLAnchorElement a = (HTMLAnchorElement) document.createElement("a");
        a.setHref(url);
        if (fileName != null)
            a.setAttribute("download", fileName);
        a.getStyle().setProperty("display", "none");
        document.getBody().appendChild(a);
        a.click();
        document.getBody().removeChild(a);
    }

}