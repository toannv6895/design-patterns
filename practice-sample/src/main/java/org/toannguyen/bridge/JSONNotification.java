package org.toannguyen.bridge;

import org.toannguyen.common.newer.NotificationChannel;

public class JSONNotification extends Notification {
    public JSONNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String recipient, String title, String content) {
        System.out.println("Preparing JSON notification...");
        String jsonContent = "{\"title\":\"" + title + "\",\"content\":\"" + content + "\"}";
        channel.sendNotification(recipient, title, jsonContent);
    }
}
