package org.toannguyen;

@Singleton
public class MyApplication {
    @Inject
    private DbService dbService;

    public boolean isSbServiceSet() {
        return dbService != null;
    }
}
