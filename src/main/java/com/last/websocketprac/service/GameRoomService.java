package com.last.websocketprac.service;

import com.last.websocketprac.dto.GameRoomDto;
import com.last.websocketprac.entity.Chatting;
import com.last.websocketprac.entity.GameRoom;
import com.last.websocketprac.repository.GameRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GameRoomService {

    @Autowired
    private GameRoomRepository gameRoomRepository;

    public GameRoom createGameRoom(GameRoomDto gameRoomDto) {
        GameRoom gameRoom = new GameRoom();
        gameRoom.setRoomName(gameRoomDto.getRoomName());
        gameRoom.setCreateAt(new Date());

        // 게임방 생성시 채팅방 연결.
        Chatting chatting = new Chatting();
        chatting.setGameRoom(gameRoom);
        gameRoom.setChatting(chatting);

        return gameRoomRepository.save(gameRoom);
    }

    public void deleteGameRoom(Long roomId) {
        gameRoomRepository.deleteById(roomId);
    }

    public boolean existsById(Long roomId) {
        return gameRoomRepository.existsById(roomId);
    }
    public String filterMessage(String message) {
        // 욕설 필터링
        return message.replaceAll("(씨발|병신|ㅅㅂ)", "**");
    }
}
