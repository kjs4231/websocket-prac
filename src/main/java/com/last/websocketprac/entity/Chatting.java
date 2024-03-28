package com.last.websocketprac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Chatting")
public class Chatting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long chatId;

    @OneToOne
    @JoinColumn(name = "room_id")
    private GameRoom gameRoom;
}