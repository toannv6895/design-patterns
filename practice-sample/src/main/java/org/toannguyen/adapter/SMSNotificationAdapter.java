package org.toannguyen.adapter;

import org.toannguyen.common.older.SMSService;

public class SMSNotificationAdapter implements NotificationSender {
    private SMSService smsService;

    public SMSNotificationAdapter(SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void send(String recipient, String title, String content) {
        smsService.sendSMS(recipient, title + ": " + content);
    }
}
