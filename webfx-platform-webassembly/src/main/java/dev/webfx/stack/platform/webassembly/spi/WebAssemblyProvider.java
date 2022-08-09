package dev.webfx.stack.platform.webassembly.spi;

import dev.webfx.stack.platform.webassembly.WebAssemblyImport;
import dev.webfx.stack.platform.webassembly.WebAssemblyInstance;
import dev.webfx.stack.platform.webassembly.WebAssemblyModule;
import dev.webfx.stack.async.Future;

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
