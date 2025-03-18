package org.toannguyen.common.older;

public class EmailService {
    public void sendEmail(String recipient, String subject, String body) {
        System.out.println("Sending email to " + recipient + " with subject: " + subject);
        System.out.println("Email body: " + body);
    }
}
