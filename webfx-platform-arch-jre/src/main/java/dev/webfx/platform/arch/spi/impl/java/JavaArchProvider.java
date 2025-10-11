package dev.webfx.platform.arch.spi.impl.java;

import dev.webfx.platform.arch.spi.ArchProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaArchProvider implements ArchProvider {

    @Override
    public boolean is64Bit() {
        String systemProp;
        systemProp = System.getProperty("com.ibm.vm.bitmode");
        if (systemProp != null) {
            return "64".equals(systemProp);
        }
        systemProp = System.getProperty("sun.arch.data.model");
        if (systemProp != null) {
            return "64".equals(systemProp);
        }
        systemProp = System.getProperty("java.vm.version");
        return systemProp != null && systemProp.contains("_64");
    }

    @Override
    public int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
