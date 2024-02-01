/*
 * Note: this code is a fork of Goodow realtime-android project https://github.com/goodow/realtime-android
 */

/*
 * Copyright 2014 Goodow.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package dev.webfx.platform.scheduler.spi.impl.java;


import dev.webfx.platform.scheduler.spi.SchedulerProviderBase;

import java.util.concurrent.*;

/*
 * @author Bruno Salmon
 */
public final class JavaSchedulerProvider extends SchedulerProviderBase {

    //private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    public JavaSchedulerProvider() {
/* Commented as this scheduler may still be used by other shutdown tasks (avoiding a RejectedExecutionException)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // shutdown our thread pool
            try {
                executor.shutdown();
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException ie) {
                // nothing to do here except go ahead and exit
            }
        }));
*/
    }

    public Executor getExecutor() {
        return executor;
    }

    @Override
    protected ScheduledBase scheduledImpl(WrappedRunnable wrappedRunnable, long delayMs) {
        ScheduledFuture<?> scheduledFuture = null;
        if (wrappedRunnable.isPeriodic())
            scheduledFuture = executor.scheduleAtFixedRate(wrappedRunnable, delayMs, delayMs, TimeUnit.MILLISECONDS);
        else if (delayMs > 0)
            scheduledFuture = executor.schedule(wrappedRunnable, delayMs, TimeUnit.MILLISECONDS);
        else if (!wrappedRunnable.isIdle())
            executor.execute(wrappedRunnable);
        else { // idle
            ScheduledFuture<?>[] scheduledIdleFuture = { null };
            scheduledFuture = scheduledIdleFuture[0] = executor.scheduleAtFixedRate(() -> {
                if (tasksCount(false, false, false, false, true) == 0) {
                    scheduledIdleFuture[0].cancel(false);
                    wrappedRunnable.run();
                }
            }, 5, 5, TimeUnit.SECONDS);
        }
        return new JavaScheduled(wrappedRunnable, scheduledFuture);
    }

    private final class JavaScheduled extends ScheduledBase {
        private final ScheduledFuture<?> scheduledFuture;

        public JavaScheduled(WrappedRunnable wrappedRunnable, ScheduledFuture<?> scheduledFuture) {
            super(wrappedRunnable);
            this.scheduledFuture = scheduledFuture;
        }

        @Override
        protected boolean cancelImpl() {
            return scheduledFuture == null || scheduledFuture.cancel(false);
        }
    }

}
