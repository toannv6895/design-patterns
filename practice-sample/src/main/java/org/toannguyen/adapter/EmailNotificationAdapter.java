package org.toannguyen.adapter;

import org.toannguyen.common.older.EmailService;

public class EmailNotificationAdapter implements NotificationSender {
    private EmailService emailService;

    public EmailNotificationAdapter(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void send(String recipient, String title, String content) {
        title = "Welcome to ABC company!";
        emailService.sendEmail(recipient, title, content);
    }
}
