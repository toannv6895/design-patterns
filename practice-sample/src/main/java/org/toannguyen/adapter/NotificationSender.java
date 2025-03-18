package org.toannguyen.adapter;

public interface NotificationSender {
    void send(String recipient, String title, String content);
}
