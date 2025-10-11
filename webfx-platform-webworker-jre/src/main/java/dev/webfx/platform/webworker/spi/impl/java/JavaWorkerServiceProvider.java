package dev.webfx.platform.webworker.spi.impl.java;

import dev.webfx.platform.webworker.spi.WorkerServiceProvider;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;
import dev.webfx.platform.webworker.WebWorker;

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
