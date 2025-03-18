package org.toannguyen;

import org.toannguyen.adapter.newer.EmailNotificationAdapter;
import org.toannguyen.adapter.newer.NotificationSender;
import org.toannguyen.adapter.newer.PushNotificationAdapter;
import org.toannguyen.adapter.newer.SMSNotificationAdapter;
import org.toannguyen.adapter.older.EmailService;
import org.toannguyen.adapter.older.PushNotificationService;
import org.toannguyen.adapter.older.SMSService;

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


        //
    }
}