package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.util.keyobject.ReadOnlyDelegatedKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class ConfigImpl extends ReadOnlyDelegatedKeyObject implements Config {

    private final Map<String, Config> childConfigs = new HashMap<>();
    private final Map<String, ConfigArray> configArrays = new HashMap<>();

    public ConfigImpl(ReadOnlyKeyObject configKeyObject) {
        super(configKeyObject);
    }

    @Override
    public Config childConfigAt(String path) {
        return (Config) TreeUtil.lookupObject(this, path);
        /*
        if (path == null || path.isEmpty())
            return this;
        int dotIndex = path.indexOf('.');
        String firstToken = dotIndex < 0 ? path : path.substring(0, dotIndex);
        Config childConfig = childConfigs.get(firstToken);
        if (childConfig == null) {
            ReadOnlyKeyObject childKeyObject = getObject(firstToken);
            if (childKeyObject == null)
                return null;
            childConfigs.put(firstToken, childConfig = new ChildConfig(getRoot(), childKeyObject));
        }
        if (dotIndex < 0)
            return childConfig;
        String subsequentPath = path.substring(dotIndex + 1);
        return childConfig.childConfigAt(subsequentPath);
         */
    }

    @Override
    public <T> T get(String key) {
        // Maybe it's a child config already built?
        Object value = childConfigs.get(key);
        if (value == null) {
            // Maybe it's a config array already built?
            value = configArrays.get(key);
            if (value == null) {
                value = super.get(key);
                if (value instanceof ReadOnlyKeyObject) { // A key object will be wrapped into a child config
                    ChildConfig childConfig = new ChildConfig(getRoot(), (ReadOnlyKeyObject) value);
                    childConfigs.put(key, childConfig);
                    value = childConfig;
                } else if (value instanceof ReadOnlyIndexedArray) { // An indexed array will be wrapped into a child array
                    ConfigArray configArray = new ConfigArray(this, (ReadOnlyIndexedArray) value);
                    configArrays.put(key, configArray);
                    value = configArray;
                } else if (value instanceof String) {
                    value = dev.webfx.platform.substitution.Substitutor.substitute((String) value);
                }
            }
        }
        return (T) value;
    }
}
