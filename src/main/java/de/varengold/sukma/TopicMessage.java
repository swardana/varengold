package de.varengold.sukma;

public class TopicMessage implements FirebaseCloudMessage {

    @Override
    public void send(NotificationVO payload) {
        System.out.println("Send to firebase cloud message.");
        FcmRes res = new FcmRes();
        payload.setResults(res);
        System.out.println("mapping specific topic related response");
    }

}
