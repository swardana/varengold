package de.varengold.sukma;

public class SendPushNotification {

    public static void push(NotificationVO payload) {
        System.out.println("Send to firebase cloud message.");
        FcmRes res = new FcmRes();
        payload.setResults(res);
        System.out.println("Map response from FCM to FcmRes");
        if ("DEVICE".equals(payload.getMessageType())) {
            System.out.println("mapping specific push token related response");
        } else if ("TOPIC".equals(payload.getMessageType())) {
            System.out.println("mapping specific topic related response");
        }
    }

}
