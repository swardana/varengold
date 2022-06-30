package de.varengold.sukma;

public class SendPushNotification {

    public static void push(NotificationVO payload) {
        System.out.println("Send to firebase cloud message.");
        FcmRes res = new FcmRes();
        payload.setResults(res);
        System.out.println("Map response from FCM to FcmRes");
    }

}
