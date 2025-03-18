package org.toannguyen.adapter.older;

public class SMSService {
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber);
        System.out.println("SMS content: " + message);
    }
}
