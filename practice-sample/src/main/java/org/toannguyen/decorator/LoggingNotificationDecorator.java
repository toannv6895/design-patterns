package org.toannguyen.decorator;

import org.toannguyen.common.newer.NotificationChannel;

public class LoggingNotificationDecorator extends NotificationDecorator {
    public LoggingNotificationDecorator(NotificationChannel wrapped) {
        super(wrapped);
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        System.out.println("LOGGING: Sending notification to " + recipient);
        wrapped.sendNotification(recipient, title, content);
        System.out.println("LOGGING: Notification sent successfully");
    }
}
