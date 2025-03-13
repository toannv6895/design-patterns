package org.toannguyen;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static GUIFactory factory;
    final static Map<String, GUIFactory> factories = Map.of("mac", new MacFactory(), "win", new WinFactory());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your machine type (mac or win): ");
        String name = scanner.nextLine();
        if (!factories.containsKey(name)) {
            System.out.println("Invalid machine type");
            return;
        }

        factory = factories.get(name);
        var button = factory.createButton();
        var checkbox = factory.createCheckbox();
        button.click();
        System.out.println(checkbox.isChecked());
    }
}