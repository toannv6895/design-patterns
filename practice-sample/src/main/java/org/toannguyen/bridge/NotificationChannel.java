package org.toannguyen.bridge;

public interface NotificationChannel {
    void sendNotification(String recipient, String title, String content);
}
