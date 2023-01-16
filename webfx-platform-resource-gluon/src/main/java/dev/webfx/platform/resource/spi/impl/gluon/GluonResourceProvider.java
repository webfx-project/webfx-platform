package dev.webfx.platform.resource.spi.impl.gluon;

import dev.webfx.platform.resource.spi.impl.java.JavaResourceProvider;

/**
 * The Java implementation is actually already fine for Gluon, but to make it work, the Gluon attach storage module also
 * needs to be added to the dependencies (even if the code to load resources doesn't explicitly use the Gluon
 * StorageService class). So we just reuse the JavaResourceProvider implementation here, and the dependency to the Gluon
 * attach module is added in webfx.xml with <plugin-module>com.gluonhq.attach.storage</plugin-module>. Also when the
 * WebFX CLI will detect that Gluon storage dependency, it will automatically add <attachList>storage</attachList> in the
 * GluonFX Maven plugin configuration of the final executable gluon module, which is necessary to activate it.
 *
 * @author Bruno Salmon
 */
public final class GluonResourceProvider extends JavaResourceProvider {
}
