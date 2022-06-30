package de.varengold.sukma;

import java.util.List;

public class FcmRes {

    private long multicastId;
    private int numberOfSuccess;
    private int numberOfFailure;
    private int numberOfCanonicalIds;
    private List<FcmResItem> results;

    public long getMulticastId() {
        return multicastId;
    }

    public void setMulticastId(long multicastId) {
        this.multicastId = multicastId;
    }

    public int getNumberOfSuccess() {
        return numberOfSuccess;
    }

    public void setNumberOfSuccess(int numberOfSuccess) {
        this.numberOfSuccess = numberOfSuccess;
    }

    public int getNumberOfFailure() {
        return numberOfFailure;
    }

    public void setNumberOfFailure(int numberOfFailure) {
        this.numberOfFailure = numberOfFailure;
    }

    public int getNumberOfCanonicalIds() {
        return numberOfCanonicalIds;
    }

    public void setNumberOfCanonicalIds(int numberOfCanonicalIds) {
        this.numberOfCanonicalIds = numberOfCanonicalIds;
    }

    public List<FcmResItem> getResults() {
        return results;
    }

    public void setResults(List<FcmResItem> results) {
        this.results = results;
    }

}
