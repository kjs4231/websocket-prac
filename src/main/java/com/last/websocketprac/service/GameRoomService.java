package com.last.websocketprac.service;

import com.last.websocketprac.dto.GameRoomDto;
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
        return gameRoomRepository.save(gameRoom);
    }

    public void deleteGameRoom(Long roomId) {
        gameRoomRepository.deleteById(roomId);
    }
}
