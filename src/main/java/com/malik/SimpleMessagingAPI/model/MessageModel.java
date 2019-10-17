package com.malik.SimpleMessagingAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageModel {

    @JsonProperty("name")
    private String name;
    private String text;

    @JsonProperty("created_time")
    private String createdTime;

    // define name and createdTime
    public MessageModel() {
        name = "Anonymous";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        Date date = new Date();
        createdTime = dateFormat.format(date);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
