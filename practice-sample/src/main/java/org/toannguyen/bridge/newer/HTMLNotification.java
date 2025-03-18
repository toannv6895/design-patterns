package org.toannguyen.bridge.newer;

import org.toannguyen.bridge.NotificationChannel;

public class HTMLNotification extends Notification {
    public HTMLNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void send(String recipient, String title, String content) {
        System.out.println("Preparing HTML notification...");
        String htmlContent = "<h1>" + title + "</h1><p>" + content + "</p>";
        channel.sendNotification(recipient, title, htmlContent);
    }
}
