package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public class DataTransfer {
    public String dropEffect;
    public String effectAllowed;
    //public FileList files;
    //public DataTransferItemList items;
    //public JsArray<String> types;

    public native void addElement(HTMLElement elem);

    public native void clearData();

    public native void clearData(String format);

    public native String getData(String format);

    public native boolean setData(String format, String data);

    public native void setDragImage(HTMLElement img, double x, int y);
}
