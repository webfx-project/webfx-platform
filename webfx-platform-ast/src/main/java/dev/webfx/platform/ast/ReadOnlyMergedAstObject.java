package dev.webfx.platform.ast;

import dev.webfx.platform.util.collection.HashList;

import java.util.*;

/**
 * @author Bruno Salmon
 */
public final class ReadOnlyMergedAstObject implements ReadOnlyAstObject {

    private final boolean deepMerge;
    private final ReadOnlyAstObject[] originalAstObjects;
    private final HashList<Object> keysList = new HashList<>();
    private final ReadOnlyAstArray keys;
    private final Map<String, Object> lazyNewValues = new HashMap<>();

    public ReadOnlyMergedAstObject(boolean deepMerge, ReadOnlyAstObject... astObjectsToMerge) {
        this.deepMerge = deepMerge;
        this.originalAstObjects = astObjectsToMerge;
        Arrays.stream(astObjectsToMerge).forEach(astObjects -> astObjects.keys().forEach(keysList::add));
        this.keys = AST.listToReadOnlyAstArray(keysList);
    }

    @Override
    public boolean has(String key) {
        return keysList.contains(key);
    }

    @Override
    public ReadOnlyAstArray keys() {
        return keys;
    }

    @Override
    public <T> T get(String key) {
        Object value = lazyNewValues.get(key);
        if (value == null && !lazyNewValues.containsKey(key)) {
            Object scalarValue = null;
            ReadOnlyAstObject astObjectValue = null;
            List<ReadOnlyAstObject> astObjectValues = null;
            for (ReadOnlyAstObject astObject : originalAstObjects) {
                value = astObject.get(key);
                if (value != null) {
                    if (!deepMerge)
                        break;
                    if (!AST.isObject(value)) {
                        if (scalarValue == null) // ignoring subsequent scalar values (keeping first found)
                            scalarValue = value;
                    } else {
                        ReadOnlyAstObject valueObject = (ReadOnlyAstObject) value;
                        if (astObjectValue == null)
                            astObjectValue = valueObject;
                        else {
                            if (astObjectValues == null) {
                                astObjectValues = new ArrayList<>();
                                astObjectValues.add(astObjectValue);
                            }
                            astObjectValues.add(valueObject);
                        }
                    }
                }
            }
            // Case when we have both scalar and object values (ex: en.yaml for graphics + en.properties for text)
            if (astObjectValue != null && scalarValue instanceof String) { // TODO: maybe make this optional as it's specific to i18n
                if (astObjectValues == null) {
                    astObjectValues = new ArrayList<>();
                    astObjectValues.add(astObjectValue);
                }
                astObjectValues.add(AST.createReadOnlySingleKeyAstObject("text", scalarValue));
            }
            if (astObjectValues != null) {
                value = new ReadOnlyMergedAstObject(true, astObjectValues.toArray(new ReadOnlyAstObject[0]));
            } else if (astObjectValue != null)
                value = astObjectValue;
            else if (scalarValue != null)
                value = scalarValue;
            lazyNewValues.put(key, value);
        }
        return (T) value;
    }

}
