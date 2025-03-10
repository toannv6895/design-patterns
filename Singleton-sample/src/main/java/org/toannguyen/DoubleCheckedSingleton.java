package org.toannguyen;

public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton instance;
    private DoubleCheckedSingleton() {}

    // Only lock when we need to create a new instance, otherwise, no need to lock to get the instance.
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
