package elemental2.webstorage;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface Storage extends JSObject {

    void clear();

    String getItem(String key);

    @JSProperty
    int getLength();

    String key(int index);

    void removeItem(String key);

    void setItem(String key, String data);

}
