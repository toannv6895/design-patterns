package org.toannguyen.adapter.newer;

public interface NotificationSender {
    void send(String recipient, String title, String content);
}
