package dev.webfx.platform.ast.json;

/**
 * @author Bruno Salmon
 */
public interface JsonElement extends ReadOnlyJsonElement {

    /**
     * Removes all entries.
     */
    void clear();

    /**
     * Removes the first instance of the given value from the list.
     *
     * @return Whether the item was removed.
     */
    //boolean removeValue(Object value);

    @Override
    default JsonObject asJsonObject() {
        return (JsonObject) this;
    }

    @Override
    default JsonArray asJsonArray() {
        return (JsonArray) this;
    }
}
