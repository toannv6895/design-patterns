package org.toannguyen.bridge;

import org.toannguyen.common.newer.NotificationChannel;

public abstract class Notification {
    protected NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void send(String recipient, String title, String content);
}
