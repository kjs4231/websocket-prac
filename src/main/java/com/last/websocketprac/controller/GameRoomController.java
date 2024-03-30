package com.last.websocketprac.controller;

import com.last.websocketprac.dto.GameRoomDto;
import com.last.websocketprac.entity.GameRoom;
import com.last.websocketprac.service.GameRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*") // CORS
@RestController
@RequestMapping("/gameRoom")
public class GameRoomController {

    private GameRoomService gameRoomService;
    public GameRoomController(GameRoomService gameRoomService) {
        this.gameRoomService = gameRoomService;
    }


    @PostMapping("/create")
    public ResponseEntity<GameRoom> createGameRoom(@RequestBody GameRoomDto gameRoomDto) {
        return ResponseEntity.ok(gameRoomService.createGameRoom(gameRoomDto));
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<?> deleteGameRoom(@PathVariable Long roomId) {
        gameRoomService.deleteGameRoom(roomId);
        return ResponseEntity.ok().build();
    }
}
