package org.toannguyen.bridge;

public class SMSChannel implements NotificationChannel {
    @Override
    public void sendNotification(String recipient, String title, String content) {
        System.out.println("Sending SMS to " + recipient);
        System.out.println("SMS content: " + title + ": " + content);
    }
}
