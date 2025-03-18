package org.toannguyen.adapter.older;

public class PushNotificationService {
    public void pushNotification(String userId, String title, String content) {
        System.out.println("Pushing notification to user " + userId + " with title: " + title);
        System.out.println("Notification content: " + content);
    }
}
