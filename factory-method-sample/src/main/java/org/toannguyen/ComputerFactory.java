package org.toannguyen;

public class ComputerFactory {
    public static Computer createComputer(String type) {
        Computer computer;
        if (type.equals("PC")) {
            computer = new PC();
        } else if (type.equals("Server")) {
            computer = new Server();
        } else {
            computer = null;
        }
        return computer;
    }
}
