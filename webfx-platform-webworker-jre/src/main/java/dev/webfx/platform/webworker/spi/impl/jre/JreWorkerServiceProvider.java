package dev.webfx.platform.webworker.spi.impl.jre;

import dev.webfx.platform.webworker.spi.WorkerServiceProvider;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;
import dev.webfx.platform.webworker.WebWorker;

/**
 * @author Bruno Salmon
 */
public class JreWorkerServiceProvider implements WorkerServiceProvider {

    @Override
    public WebWorker createWorker(String scriptUrl) {
        return new JreWebWorker(scriptUrl);
    }

    @Override
    public WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass) {
        return new JreWebWorker(javaCodedWorkerClass);
    }
}
