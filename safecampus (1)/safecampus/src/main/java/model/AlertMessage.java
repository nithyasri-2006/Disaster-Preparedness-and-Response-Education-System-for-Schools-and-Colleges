package com.safecampus.safecampus.model;

public class AlertMessage {

    private String message;

    public AlertMessage() {}

    public AlertMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}