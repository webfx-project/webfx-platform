package dev.webfx.platform.blob.spi.impl.gwt;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.BlobProvider;
import elemental2.dom.Blob.ConstructorBlobPartsArrayUnionType;
import elemental2.dom.BlobPropertyBag;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLLinkElement;

/**
 * @author Bruno Salmon
 */
public final class GwtBlobProvider implements BlobProvider {

    @Override
    public Blob createBlob(Object platformBlob) {
        return new GwtBlob((elemental2.dom.Blob) platformBlob);
    }

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
        a.click();
        DomGlobal.document.body.removeChild(a);
    }

}
