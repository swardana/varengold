package de.varengold.sukma;

public class Request {

    private String alertTitle;
    private String alertText;
    /**
     * TOPIC: push to all deice which subscribe which topic
     * DEVICE: push to special device
     */
    private String messageType;
    /**
     * if messageType is DEVICE, this field is required.
     */
    private String pushTokens;
    /**
     * if messageType is TOPIC this field is required
     */
    private String topics;

    public String getAlertTitle() {
        return alertTitle;
    }

    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getPushTokens() {
        return pushTokens;
    }

    public void setPushTokens(String pushTokens) {
        this.pushTokens = pushTokens;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

}
