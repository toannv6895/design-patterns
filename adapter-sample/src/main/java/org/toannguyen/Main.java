package org.toannguyen;

public class Main {
    public static void main(String[] args) {
        PrintAdapter printAdapter = new PrintAdapter(new StandardExternalLibrary());

        printAdapter.printMessage("toannguyen test");
    }
}