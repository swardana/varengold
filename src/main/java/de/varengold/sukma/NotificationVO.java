package de.varengold.sukma;

import java.util.List;

public class NotificationVO {

    private String status;
    private List<String> topics;
    private List<String> devices;
    private String messageType;
    private FcmRes results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public FcmRes getResults() {
        return results;
    }

    public void setResults(FcmRes results) {
        this.results = results;
    }
}
