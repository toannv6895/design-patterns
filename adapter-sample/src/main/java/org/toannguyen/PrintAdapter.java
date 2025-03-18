package org.toannguyen;

public class PrintAdapter implements ModernPrinter {
    ExternalLibrary adaptee;

    public PrintAdapter(ExternalLibrary externalLibrary) {
        this.adaptee = externalLibrary;
    }

    @Override
    public void printMessage(String message) {
        if (message.contains("standard")) {
            adaptee.print();
        }
        else {
            System.out.println("This is ABC company with message: " + message);
        }
    }
}
