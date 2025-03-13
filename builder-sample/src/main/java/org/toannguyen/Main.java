package org.toannguyen;

public class Main {
    public static void main(String[] args) {
        var customer = new Customer.Builder("Toan")
                .setAge(29)
                .build();
        System.out.println(customer.toString());
    }
}