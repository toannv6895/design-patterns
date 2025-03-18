package org.toannguyen.common.newer;

public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(String recipient, String title, String content) {
        System.out.println("Sending email to " + recipient + " with subject: " + title);
        System.out.println("Email body: " + content);
    }
}
