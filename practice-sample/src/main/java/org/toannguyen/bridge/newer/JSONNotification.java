package org.toannguyen.bridge.newer;

import org.toannguyen.bridge.NotificationChannel;

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
