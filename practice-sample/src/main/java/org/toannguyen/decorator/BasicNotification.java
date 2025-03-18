package org.toannguyen.decorator;

import org.toannguyen.common.newer.NotificationChannel;

public class BasicNotification implements NotificationChannel {
    private NotificationChannel channel;

    public BasicNotification(NotificationChannel channel) {
        this.channel = channel;
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        channel.sendNotification(recipient, title, content);
    }
}
