package org.toannguyen.decorator;

import org.toannguyen.common.newer.NotificationChannel;

public class EncryptedNotificationDecorator extends NotificationDecorator {
    public EncryptedNotificationDecorator(NotificationChannel wrapped) {
        super(wrapped);
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        System.out.println("ENCRYPTING: Encrypting notification content");
        String encryptedContent = encrypt(content);
        wrapped.sendNotification(recipient, title, encryptedContent);
    }

    private String encrypt(String content) {
        return "ENCRYPTED[" + content + "]";
    }
}
