package dev.webfx.platform.webworker;

import dev.webfx.platform.webworker.spi.WorkerServiceProvider;
import dev.webfx.platform.webworker.spi.base.JavaCodedWebWorkerBase;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class WebWorkerService {

    private WebWorkerService() {}

    private static WorkerServiceProvider getProvider() {
        return SingleServiceProvider.getProvider(WorkerServiceProvider.class, () -> ServiceLoader.load(WorkerServiceProvider.class));
    }

    public static WebWorker createWorker(String scriptUrl) {
        return getProvider().createWorker(scriptUrl);
    }

    public static WebWorker createWorker(Class<? extends JavaCodedWebWorkerBase> javaCodedWorkerClass) {
        return getProvider().createWorker(javaCodedWorkerClass);
    }

}
