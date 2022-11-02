package dev.webfx.platform.json;

/**
 * @author Bruno Salmon
 */
public interface WritableJsonElement extends JsonElement {

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
    default WritableJsonObject asJsonObject() {
        return (WritableJsonObject) this;
    }

    @Override
    default WritableJsonArray asJsonArray() {
        return (WritableJsonArray) this;
    }
}
