package org.toannguyen.log;

public class LazyLogManager {
    private static LazyLogManager instance;
    private LazyLogManager() {}
    public static LazyLogManager getInstance() {
        if (instance == null) {
            instance = new LazyLogManager();
        }

        return instance;
    }
}
