package org.toannguyen.common.newer;

public class PushChannel implements NotificationChannel {
    @Override
    public void sendNotification(String recipient, String title, String content) {
        System.out.println("Pushing notification to user " + recipient + " with title: " + title);
        System.out.println("Notification content: " + content);
    }
}
