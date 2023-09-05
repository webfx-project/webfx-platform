package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.ast.ReadOnlyAstArrayWrapper;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;

/**
 * @author Bruno Salmon
 */
public class ConfigArray extends ReadOnlyAstArrayWrapper {

    private final ConfigImpl parentConfig;
    private final Config[] childConfigs;
    private final ConfigArray[] configArrays;


    public ConfigArray(ConfigImpl parentConfig, ReadOnlyAstArray delegate) {
        super(delegate);
        this.parentConfig = parentConfig;
        childConfigs = new Config[size()];
        configArrays = new ConfigArray[size()];
    }

    @Override
    public <V> V getElement(int index) {
        // Maybe it's a child config already built?
        Object value = childConfigs[index];
        if (value == null) {
            // Maybe it's a config array already built?
            value = configArrays[index];
            if (value == null) {
                value = super.getElement(index);
                if (value instanceof ReadOnlyAstObject) { // A key object will be wrapped into a child config
                    ChildConfig childConfig = new ChildConfig(parentConfig.getRoot(), (ReadOnlyAstObject) value);
                    childConfigs[index] = childConfig;
                    value = childConfig;
                } else if (value instanceof ReadOnlyAstArray) { // An indexed array will be wrapped into a child array
                    ConfigArray configArray = new ConfigArray(parentConfig, (ReadOnlyAstArray) value);
                    configArrays[index] = configArray;
                    value = configArray;
                } else if (value instanceof String) {
                    value = dev.webfx.platform.substitution.Substitutor.substitute((String) value);
                }
            }
        }
        return (V) value;
    }
}
