package de.varengold.sukma;

public class TopicMessage implements FirebaseCloudMessage {

    private NotificationVO payload;

    public TopicMessage(NotificationVO payload) {
        this.payload = payload;
    }

    @Override
    public FcmRes send() {
        /**
         * Map the {@code payload} data into
         * fcm request.
         */
        System.out.println("Send to firebase cloud message.");
        FcmRes res = new FcmRes();
        System.out.println("mapping specific topic related response to FcmRes");
        return res;
    }

}
