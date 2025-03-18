package org.toannguyen.proxy;

import org.toannguyen.common.newer.NotificationChannel;
import org.toannguyen.decorator.BasicNotification;

import java.util.HashMap;
import java.util.Map;

public class NotificationServiceProxy implements NotificationChannel {
    BasicNotification realNotification;
    private Map<String, Integer> notificationCount = new HashMap<>();
    private int MAX_NOTIFICATIONS_PER_RECIPIENT = 5;

    public NotificationServiceProxy(NotificationChannel channel) {
        this.realNotification = new BasicNotification(channel);
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        int count = notificationCount.getOrDefault(recipient, 0);

        if (count >= MAX_NOTIFICATIONS_PER_RECIPIENT) {
            System.out.println("PROXY: Maximum notification limit reached for " + recipient);
            return;
        }

        notificationCount.put(recipient, count + 1);

        System.out.println("PROXY: Authorization check passed");
        System.out.println("PROXY: Rate limit check passed (" + (count + 1) + "/" + MAX_NOTIFICATIONS_PER_RECIPIENT + ")");

        realNotification.sendNotification(recipient, title, content);
    }
}
