package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String message;

    public Message() {

    }
    public Message(String msg)
    {
        this.message=msg;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
