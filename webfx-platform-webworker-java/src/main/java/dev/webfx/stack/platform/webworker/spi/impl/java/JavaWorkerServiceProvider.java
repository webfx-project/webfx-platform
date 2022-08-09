package dev.webfx.stack.platform.webworker.spi.impl.java;

import dev.webfx.stack.platform.webworker.WebWorker;
import dev.webfx.stack.platform.webworker.spi.base.JavaCodedWebWorkerBase;
import dev.webfx.stack.platform.webworker.spi.WorkerServiceProvider;

/**
 * @author Bruno Salmon
 */
public class JavaWorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public WebWorker createWorker(String scriptUrl) {
        return new JavaWebWorker(scriptUrl);
    }

    @Override
    public WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass) {
        return new JavaWebWorker(javaCodedWorkerClass);
    }
}
