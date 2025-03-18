package org.toannguyen.bridge.newer;

import org.toannguyen.bridge.NotificationChannel;

public abstract class Notification {
    protected NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void send(String recipient, String title, String content);
}
