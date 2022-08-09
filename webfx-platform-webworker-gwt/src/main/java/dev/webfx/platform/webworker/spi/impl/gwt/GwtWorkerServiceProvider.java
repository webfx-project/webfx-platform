package dev.webfx.platform.webworker.spi.impl.gwt;

import dev.webfx.platform.webworker.WebWorker;
import dev.webfx.platform.webworker.spi.WorkerServiceProvider;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;

/**
 * @author Bruno Salmon
 */
public class GwtWorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public WebWorker createWorker(String scriptUrl) {
        return new GwtWebWorker(scriptUrl);
    }

    @Override
    public WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass) {
        return createWorker(javaCodedWorkerClass.getName() + ".js");
    }
}
