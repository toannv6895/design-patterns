package org.toannguyen.log;

public class ImmutableLogManager {
    private static final ImmutableLogManager instance = new ImmutableLogManager();
    private ImmutableLogManager() {}
    public static ImmutableLogManager getInstance() {
        return instance;
    }
}
