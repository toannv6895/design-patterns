package org.toannguyen;

import org.toannguyen.adapter.EmailNotificationAdapter;
import org.toannguyen.adapter.NotificationSender;
import org.toannguyen.adapter.PushNotificationAdapter;
import org.toannguyen.adapter.SMSNotificationAdapter;
import org.toannguyen.common.newer.EmailChannel;
import org.toannguyen.common.newer.PushChannel;
import org.toannguyen.common.newer.SMSChannel;
import org.toannguyen.common.older.EmailService;
import org.toannguyen.common.older.PushNotificationService;
import org.toannguyen.common.older.SMSService;
import org.toannguyen.bridge.HTMLNotification;
import org.toannguyen.bridge.JSONNotification;
import org.toannguyen.common.newer.NotificationChannel;
import org.toannguyen.bridge.Notification;
import org.toannguyen.bridge.TextNotification;
import org.toannguyen.decorator.BasicNotification;
import org.toannguyen.decorator.EncryptedNotificationDecorator;
import org.toannguyen.decorator.LoggingNotificationDecorator;
import org.toannguyen.decorator.TrackingNotificationDecorator;

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

        System.out.println("============");

        // decorator
        NotificationChannel basicNotification = new BasicNotification(emailChannel);
        NotificationChannel trackedNotification = new TrackingNotificationDecorator(basicNotification);
        NotificationChannel encryptedTrackedNotification = new EncryptedNotificationDecorator(trackedNotification);
        NotificationChannel fullFeaturedNotification = new LoggingNotificationDecorator(encryptedTrackedNotification);

        // send email with full feature
        fullFeaturedNotification.sendNotification("user@example.com", "Security Alert", "Your account was accessed from a new device");
    }
}