package dev.webfx.platform.fetch;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.NamedBlob;

import java.util.*;

/**
 * @author Bruno Salmon
 */
public class FormData {

    private final Map<String, Object> map = new LinkedHashMap();

    private final FormData append(String name, Object value, String filename) {
        Object previousValue = map.get(name);
        if (previousValue == null)
            set(name, value, filename);
        else {
            List values;
            if (previousValue instanceof List) {
                values = (List<Object>) previousValue;
            } else
                values = new ArrayList();
            values.add(convertValue(value, filename));
        }
        return this;
    }

    private Object convertValue(Object value, String filename) {
        return value == null ? null : filename == null ? value : new NamedBlob((Blob) value, filename);
    }

    public final FormData append(String name, Blob value, String filename) {
        return append(name, (Object) value, filename);
    }

    public final FormData append(String name, Blob value) {
        return append(name, value, null);
    }

    public final FormData append(String name, String value) {
        return append(name, value, null);
    }

    public final FormData append(String name, Boolean value) {
        return append(name, value, null);
    }

    public FormData delete(String name) {
        map.remove(name);
        return this;
    }

    //public native FormData.GetUnionType get(String name);

    //public native JsArray<FormData.GetAllArrayUnionType> getAll(String name);

    public boolean has(String name) {
        return map.containsKey(name);
    }

    public Set<Map.Entry<String, Object>> entries() {
        return map.entrySet();
    }

    private final FormData set(String name, Object value, String filename) {
        map.put(name, convertValue(value, filename));
        return this;
    }

    public final FormData set(String name, Blob value, String filename) {
        return set(name, (Object) value, filename);
    }

    public final FormData set(String name, Blob value) {
        return set(name, value, null);
    }

    public final FormData set(String name, String value, String filename) {
        return set(name, (Object) value, filename);
    }

    public final FormData set(String name, String value) {
        return set(name, value, null);
    }

}
