package org.toannguyen;

public class BillPughSingleton {
    private static BillPughSingleton instance;
    private BillPughSingleton() {}
    // Significant knowledge: class loader load parent class, not child class (inner class) into memory until it is called
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
