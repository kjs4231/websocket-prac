package com.last.websocketprac.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
@Table(name = "Game_room")
public class GameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "room_name")
    private String roomName;

    @OneToOne(mappedBy = "gameRoom", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Chatting chatting;

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setChatting(Chatting chatting) {
        this.chatting = chatting;
    }



}
