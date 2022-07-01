package de.varengold.sukma;

public class DeviceMessage implements FirebaseCloudMessage {

    private NotificationVO payload;

    public DeviceMessage(NotificationVO payload) {
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
        System.out.println("mapping specific device related response to FcmRes");
        return res;
    }

}
