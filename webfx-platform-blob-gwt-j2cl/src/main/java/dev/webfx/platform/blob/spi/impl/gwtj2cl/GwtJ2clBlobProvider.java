package dev.webfx.platform.blob.spi.impl.gwtj2cl;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.BlobProvider;
import elemental2.dom.Blob.ConstructorBlobPartsArrayUnionType;
import elemental2.dom.BlobPropertyBag;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clBlobProvider implements BlobProvider {

    @Override
    public Blob createBlob(Object platformBlob) {
        return new GwtJ2clBlob((elemental2.dom.Blob) platformBlob);
    }

    @Override
    public Blob createTextBlob(String text) {
        ConstructorBlobPartsArrayUnionType[] parts = { ConstructorBlobPartsArrayUnionType.of(text) };
        BlobPropertyBag bag = BlobPropertyBag.create();
        bag.setType("text/plain");
        return new GwtJ2clBlob(new elemental2.dom.Blob(parts, bag));
    }

    @Override
    public void downloadUrl(String url, String fileName) {
        HTMLAnchorElement a = (HTMLAnchorElement) DomGlobal.document.createElement("a");
        a.href = url;
        if (fileName != null)
            a.setAttribute("download", fileName);
        a.style.display = "none";
        DomGlobal.document.body.appendChild(a);
        a.click();
        DomGlobal.document.body.removeChild(a);
    }
}
