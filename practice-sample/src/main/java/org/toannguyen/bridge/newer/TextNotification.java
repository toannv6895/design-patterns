package org.toannguyen.bridge.newer;

import org.toannguyen.bridge.NotificationChannel;

public class TextNotification extends Notification {
    public TextNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String recipient, String title, String content) {
        System.out.println("Preparing TEXT notification...");
        channel.sendNotification(recipient, title, content);
    }
}
