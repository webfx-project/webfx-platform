package dev.webfx.platform.webassembly;

import dev.webfx.platform.async.Future;

/**
 * @author Bruno Salmon
 */
public interface WebAssemblyModule {

    Future<WebAssemblyInstance> instantiate(WebAssemblyImport... imports);

}
