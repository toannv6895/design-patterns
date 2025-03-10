package org.toannguyen;

public class ImmutableSingleton {
    // use final to make sure it can't be changed, so we don't need to lock => thread safe
    private static final ImmutableSingleton instance =  new ImmutableSingleton();
    private ImmutableSingleton() {}
    public static ImmutableSingleton getInstance() {
        return instance;
    }
}
