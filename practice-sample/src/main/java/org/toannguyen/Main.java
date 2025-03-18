package org.toannguyen;

import org.toannguyen.adapter.newer.EmailNotificationAdapter;
import org.toannguyen.adapter.newer.NotificationSender;
import org.toannguyen.adapter.newer.PushNotificationAdapter;
import org.toannguyen.adapter.newer.SMSNotificationAdapter;
import org.toannguyen.adapter.older.EmailService;
import org.toannguyen.adapter.older.PushNotificationService;
import org.toannguyen.adapter.older.SMSService;
import org.toannguyen.bridge.*;
import org.toannguyen.bridge.newer.HTMLNotification;
import org.toannguyen.bridge.newer.JSONNotification;
import org.toannguyen.bridge.NotificationChannel;
import org.toannguyen.bridge.newer.Notification;
import org.toannguyen.bridge.newer.TextNotification;

public class Main {
    public static void main(String[] args) {
        // adapter
        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();
        PushNotificationService pushService = new PushNotificationService();

        NotificationSender emailSender = new EmailNotificationAdapter(emailService);
        NotificationSender smsSender = new SMSNotificationAdapter(smsService);
        NotificationSender pushSender = new PushNotificationAdapter(pushService);

        emailSender.send("user@example.com", "Welcome", "Welcome to our service!");
        smsSender.send("+1234567890", "Verification", "Your code is 123456");
        pushSender.send("user123", "New message", "You have a new message");

        System.out.println("============");

        // bridge
        // When i need to support 3 notification types
        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SMSChannel();
        NotificationChannel pushChannel = new PushChannel();

        Notification textEmailNotification = new TextNotification(emailChannel);
        Notification htmlEmailNotification = new HTMLNotification(emailChannel);
        Notification jsonPushNotification = new JSONNotification(pushChannel);
        Notification textSMSNotification = new TextNotification(smsChannel);

        textEmailNotification.send("user@example.com", "Welcome", "Welcome to our service!");
        htmlEmailNotification.send("user@example.com", "Newsletter", "Check out our latest products!");
        jsonPushNotification.send("user123", "New message", "You have a new message");
        textSMSNotification.send("+1234567890", "Verification", "Your code is 123456");
    }
}