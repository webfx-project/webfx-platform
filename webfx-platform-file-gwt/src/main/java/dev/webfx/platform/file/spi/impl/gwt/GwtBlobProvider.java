package dev.webfx.platform.file.spi.impl.gwt;

import dev.webfx.platform.file.Blob;
import dev.webfx.platform.file.spi.BlobProvider;
import elemental2.dom.Blob.ConstructorBlobPartsArrayUnionType;
import elemental2.dom.BlobPropertyBag;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLLinkElement;

/**
 * @author Bruno Salmon
 */
public final class GwtBlobProvider implements BlobProvider {

    @Override
    public Blob createTextBlob(String text) {
        ConstructorBlobPartsArrayUnionType[] parts = { ConstructorBlobPartsArrayUnionType.of(text) };
        BlobPropertyBag bag = BlobPropertyBag.create();
        bag.setType("text/plain");
        return new GwtBlob(new elemental2.dom.Blob(parts, bag));
    }

    @Override
    public void exportBlob(Blob blob, String fileName) {
        HTMLLinkElement a = (HTMLLinkElement) DomGlobal.document.createElement("a");
        a.href = blob.getObjectURL();
        a.setAttribute("download", fileName);
        a.style.display = "none";
        DomGlobal.document.body.appendChild(a);
        click(a);
        DomGlobal.document.body.removeChild(a);
    }

    private static native void click(HTMLLinkElement a) /*-{
        a.click();
    }-*/;
}
