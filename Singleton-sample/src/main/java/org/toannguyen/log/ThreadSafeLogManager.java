package org.toannguyen.log;

public class ThreadSafeLogManager {
    private static ThreadSafeLogManager instance;
    private ThreadSafeLogManager() {}
    public static synchronized ThreadSafeLogManager getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLogManager();
        }

        return instance;
    }
}
