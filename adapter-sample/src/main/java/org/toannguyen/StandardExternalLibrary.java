package org.toannguyen;

public class StandardExternalLibrary implements ExternalLibrary {
    @Override
    public void print() {
        System.out.println("Standard external library");
    }
}
