package dev.webfx.stack.platform.webworker.spi.impl.gwt;

import dev.webfx.stack.platform.webworker.WebWorker;
import dev.webfx.stack.platform.webworker.spi.base.JavaCodedWebWorkerBase;
import dev.webfx.stack.platform.webworker.spi.WorkerServiceProvider;

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
