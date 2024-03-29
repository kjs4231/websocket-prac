package com.last.websocketprac.controller;

import com.last.websocketprac.dto.ChatMessage;
import com.last.websocketprac.service.GameRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ChatController {

    private SimpMessageSendingOperations messagingTemplate;
    private GameRoomService gameRoomService;
    public ChatController(SimpMessageSendingOperations messagingTemplate, GameRoomService gameRoomService) {
        this.messagingTemplate = messagingTemplate;
        this.gameRoomService = gameRoomService;
    }


    @MessageMapping("/chat.sendMessage/{roomId}")
    public void sendMessage(@DestinationVariable Long roomId, @Payload ChatMessage chatMessage) {

        if (!gameRoomService.existsById(roomId)) {
            // 여기서 오류 처리 로직을 구현합니다. 예를 들어, 오류 로깅을 하거나 클라이언트에 오류 메시지를 전송합니다.
            return; // 방이 존재하지 않으면 메서드를 종료합니다.
        }

        String filteredContent = gameRoomService.filterMessage(chatMessage.getContent());
        chatMessage.setContent(filteredContent);

        // 동적으로 메시지를 라우팅할 주소를 생성, 이부분 좀더 공부하고 이해가 필요...
        String destination = "/topic/gameRoom/" + roomId;

        messagingTemplate.convertAndSend(destination, chatMessage);
    }


    @MessageMapping("/chat.addUser/{roomId}")
    public void addUser(@DestinationVariable Long roomId, @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {

        //이거 방이 없어도 없는 게임방번호 입력하면 채팅이 열리는 문제가 발생해서 검증로직 추가한거.
        if (!gameRoomService.existsById(roomId)) {
            return;
        }

        headerAccessor.getSessionAttributes().put("room_id", roomId); //에러난 이유 : 헤더에 방번호를 추가안해줘서 나갔을때 어느방에서 나갔는지 모르기에 퇴장 메세지 안떴음.
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        String destination = "/topic/gameRoom/" + roomId;

        // 입장 메시지 전송.
        messagingTemplate.convertAndSend(destination, chatMessage);
    }
}