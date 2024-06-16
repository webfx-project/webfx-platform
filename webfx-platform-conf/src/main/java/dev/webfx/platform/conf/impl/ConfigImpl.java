package dev.webfx.platform.conf.impl;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.ast.ReadOnlyAstObjectWrapper;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.AST;
import dev.webfx.platform.substitution.Substitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class ConfigImpl extends ReadOnlyAstObjectWrapper implements Config {

    private final Config parentConfig;
    private final Map<String, Config> childConfigs = new HashMap<>();
    private final Map<String, ConfigArray> configArrays = new HashMap<>();

    public ConfigImpl(ReadOnlyAstObject configAstObject, Config parentConfig) {
        super(configAstObject);
        this.parentConfig = parentConfig;
    }

    @Override
    public Config parentConfig() {
        return parentConfig;
    }

    @Override
    public Config childConfigAt(String path) {
        return (Config) AST.lookupObject(this, path);
        /*
        if (path == null || path.isEmpty())
            return this;
        int dotIndex = path.indexOf('.');
        String firstToken = dotIndex < 0 ? path : path.substring(0, dotIndex);
        Config childConfig = childConfigs.get(firstToken);
        if (childConfig == null) {
            ReadOnlyAstObject childAstObject = getObject(firstToken);
            if (childAstObject == null)
                return null;
            childConfigs.put(firstToken, childConfig = new ChildConfig(getRoot(), childAstObject));
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
                if (AST.isObject(value)) { // A key object will be wrapped into a child config
                    ChildConfig childConfig = new ChildConfig(this, (ReadOnlyAstObject) value);
                    childConfigs.put(key, childConfig);
                    value = childConfig;
                } else if (AST.isArray(value)) { // An indexed array will be wrapped into a child array
                    ConfigArray configArray = new ConfigArray(this, (ReadOnlyAstArray) value);
                    configArrays.put(key, configArray);
                    value = configArray;
                }
            }
        }
        if (value == null) {
            try (ThreadLocalConfigContext context = ThreadLocalConfigContext.open(this)) {
                value = Substitutor.substitute(key);
                if (value == key)
                    value = null;
            }
        } else if (value instanceof String) {
            // TODO: Should be substitution optional?
            try (ThreadLocalConfigContext context = ThreadLocalConfigContext.open(this)) {
                value = Substitutor.substitute((String) value);
            }
        }
        return (T) value;
    }
}
