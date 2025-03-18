package org.toannguyen.decorator;

import org.toannguyen.common.newer.NotificationChannel;

public class TrackingNotificationDecorator extends NotificationDecorator {
    public TrackingNotificationDecorator(NotificationChannel wrapped) {
        super(wrapped);
    }

    @Override
    public void sendNotification(String recipient, String title, String content) {
        String trackingId = generateTrackingId();
        System.out.println("TRACKING: Assigned tracking ID " + trackingId);
        wrapped.sendNotification(recipient, title, content + " [Tracking ID: " + trackingId + "]");
    }

    private String generateTrackingId() {
        return "TRK-" + Math.round(Math.random() * 10000);
    }
}
