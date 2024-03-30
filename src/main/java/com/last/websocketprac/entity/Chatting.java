package com.last.websocketprac.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Chatting")
public class Chatting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long chatId;

    @OneToOne
    @JoinColumn(name = "room_id")
    private GameRoom gameRoom;

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
    }
}