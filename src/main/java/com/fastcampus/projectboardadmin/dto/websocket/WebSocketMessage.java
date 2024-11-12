package com.fastcampus.projectboardadmin.dto.websocket;

import java.io.Serializable;

public record WebSocketMessage(String content) implements Serializable {

    public static WebSocketMessage of(String content) {
        return new WebSocketMessage(content);
    }
}
