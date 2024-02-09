package com.example.kafkaproducertwo.dto;

public class Farewell {

    private String message;
    private Integer remainingMinutes;

    // standard getters, setters and constructor
    public Farewell(String message, Integer remainingMinutes) {
        this.message = message;
        this.remainingMinutes = remainingMinutes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(Integer remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }
}