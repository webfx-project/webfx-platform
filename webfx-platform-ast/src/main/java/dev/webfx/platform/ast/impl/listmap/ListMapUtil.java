package dev.webfx.platform.ast.impl.listmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public final class ListMapUtil {

    @SuppressWarnings("unchecked")
    public static List<Object> convertList(List<?> list) {
        List<Object> arr = new ArrayList<>(list.size());
        for (Object obj : list) {
            if (obj instanceof Map)
                arr.add(convertMap((Map<String, Object>) obj));
            else if (obj instanceof List)
                arr.add(convertList((List<?>) obj));
            else
                arr.add(obj);
        }
        return arr;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> convertMap(Map<String, Object> map) {
        Map<String, Object> converted = new LinkedHashMap<>(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object obj = entry.getValue();
            if (obj instanceof Map) {
                Map<String, Object> jm = (Map<String, Object>) obj;
                converted.put(entry.getKey(), convertMap(jm));
            } else if (obj instanceof List) {
                List<Object> list = (List<Object>) obj;
                converted.put(entry.getKey(), convertList(list));
            } else
                converted.put(entry.getKey(), obj);
        }
        return converted;
    }
}