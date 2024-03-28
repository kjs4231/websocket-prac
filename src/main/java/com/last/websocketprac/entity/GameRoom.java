package com.last.websocketprac.entity;

import com.last.websocketprac.entity.Chatting;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "GameRoom")
public class GameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "playing")
    private String playing;


}
