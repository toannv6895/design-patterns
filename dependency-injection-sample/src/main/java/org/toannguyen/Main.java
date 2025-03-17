package org.toannguyen;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = BeanFactory.INSTANCE;
        Message message1 = beanFactory.getInstanceOf(Message.class, "Hello");
        System.out.println("Message 1: " + message1);

        Message message2 = beanFactory.getInstanceOf(Message.class, "word");
        System.out.println("Message 2: " + message2);
    }
}