package de.varengold.sukma;

public class App {

    public static void main(String[] args) {
        Request request = new Request();
        request.setAlertTitle("Send message");
        request.setAlertText("Hello World");
        request.setPushTokens("12345,12335,7356546");
        PushNotificationService service = new PushNotificationService();
        service.execute(request);
    }
}
