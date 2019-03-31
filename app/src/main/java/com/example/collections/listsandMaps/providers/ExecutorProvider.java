package com.example.collections.listsandMaps.providers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ExecutorProvider {

    private static volatile ExecutorService executorService;

    private ExecutorProvider() {
    }

    public static int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static ExecutorService getExecutorService() {

        if (executorService == null) {
            synchronized (ExecutorProvider.class) {
                executorService = Executors.newFixedThreadPool(getNumberOfCores());
            }
        }
        return executorService;
    }
}
