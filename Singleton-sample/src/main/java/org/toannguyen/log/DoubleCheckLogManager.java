package org.toannguyen.log;

public class DoubleCheckLogManager {
    private static DoubleCheckLogManager instance;
    private DoubleCheckLogManager() {}
    public static DoubleCheckLogManager getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLogManager.class) {
                if (instance == null) {
                    instance = new DoubleCheckLogManager();
                }
            }
        }

        return instance;
    }
}
