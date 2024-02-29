package dev.webfx.platform.webworker.spi.impl.gwtj2cl;

import dev.webfx.platform.webworker.WebWorker;
import dev.webfx.platform.webworker.spi.WorkerServiceProvider;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clWorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public WebWorker createWorker(String scriptUrl) {
        return new GwtJ2clWebWorker(scriptUrl);
    }

    @Override
    public WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass) {
        return createWorker(javaCodedWorkerClass.getName() + ".js");
    }
}
