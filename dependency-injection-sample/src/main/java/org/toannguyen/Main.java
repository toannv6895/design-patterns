package org.toannguyen;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = BeanFactory.INSTANCE;
        Message message1 = beanFactory.getInstanceOf(Message.class, "Hello");
        System.out.println("Message 1: " + message1);

        Message message2 = beanFactory.getInstanceOf(Message.class, "word");
        System.out.println("Message 2: " + message2);

        // use singleton annotation
        DbService dbService1 = beanFactory.getInstanceOf(DbService.class);
        DbService dbService2 = beanFactory.getInstanceOf(DbService.class);
        System.out.println("Instances of DBService are the same? " + (dbService1 == dbService2));
    }
}