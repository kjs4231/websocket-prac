package com.last.websocketprac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter

public class ChatMessage {
    private String content;
    private String sender;

    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
