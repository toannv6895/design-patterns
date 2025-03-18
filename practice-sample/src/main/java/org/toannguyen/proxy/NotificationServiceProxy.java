package org.toannguyen.proxy;

import org.toannguyen.common.newer.NotificationChannel;
import org.toannguyen.decorator.BasicNotification;

public class NotificationServiceProxy extends NotificationProxy {
    public NotificationServiceProxy(NotificationChannel channel) {
        this.realNotificationChanel = channel;
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        if (this.realNotification == null) {
            this.realNotification = new BasicNotification(realNotificationChanel);
        }

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
