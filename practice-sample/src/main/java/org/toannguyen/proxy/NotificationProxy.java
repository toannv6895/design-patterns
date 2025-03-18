package org.toannguyen.proxy;

import org.toannguyen.common.newer.NotificationChannel;
import org.toannguyen.decorator.BasicNotification;

import java.util.HashMap;
import java.util.Map;

public abstract class NotificationProxy implements NotificationChannel {
    BasicNotification realNotification;
    protected NotificationChannel realNotificationChanel;
    protected Map<String, Integer> notificationCount = new HashMap<>();
    protected int MAX_NOTIFICATIONS_PER_RECIPIENT = 5;
}
