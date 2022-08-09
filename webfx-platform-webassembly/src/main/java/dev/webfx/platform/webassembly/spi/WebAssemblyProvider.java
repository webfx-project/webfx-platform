package dev.webfx.platform.webassembly.spi;

import dev.webfx.platform.webassembly.WebAssemblyImport;
import dev.webfx.platform.webassembly.WebAssemblyInstance;
import dev.webfx.platform.webassembly.WebAssemblyModule;
import dev.webfx.platform.async.Future;

/**
 * @author Bruno Salmon
 */
public interface WebAssemblyProvider {

    boolean isSupported();

    Future<WebAssemblyModule> loadModule(String url);

    default Future<WebAssemblyInstance> loadAndInstantiate(String webAssemblyUrl, WebAssemblyImport... imports) {
        return loadModule(webAssemblyUrl).compose(module -> module.instantiate(imports));
    }

}
