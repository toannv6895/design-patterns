package org.toannguyen.adapter.newer;

import org.toannguyen.adapter.older.PushNotificationService;

public class PushNotificationAdapter implements NotificationSender {
    private PushNotificationService pushService;

    public PushNotificationAdapter(PushNotificationService pushService) {
        this.pushService = pushService;
    }

    @Override
    public void send(String recipient, String title, String content) {
        content += ", please use your code received from SMS to verify, contact to " + recipient + " if you have any question!";
        pushService.pushNotification(recipient, title, content);
    }
}
