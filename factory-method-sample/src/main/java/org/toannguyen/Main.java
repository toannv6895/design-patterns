package org.toannguyen;

public class Main {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.createComputer("PC");
        Computer server = ComputerFactory.createComputer("Server");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }
}