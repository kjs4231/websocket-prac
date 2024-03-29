package com.last.websocketprac.controller;

import com.last.websocketprac.dto.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ChatController {

    @MessageMapping("/chat.sendMessage") // 이게 핸들러 역할.
    // 클라이언트가 /chat.sendMessage를 통해 메시지를 보내면 이 메소드가 처리하고 처리된 결과가 /topic/public으로 구독된 클라이언트에게 전송.
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) { //@Payload 객체로 메세지를 받아들임.
        // 서비스 처리한게 없으니 그대로 반환. 나중에 할때 서비스에 넣을게 뭐가 있을까? 검열? 그건 프론트에서 하는건가? 접속자 확인?
        // 더 알아보니 검열은 컨트롤러에서 가능!!
        return chatMessage;
    }

    @MessageMapping("/chat.addUser") // 이 엔드포인트로 클라이언트가 JSON.stringify({sender: username, type: 'JOIN'}) 보냄.
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               //SimpMessageHeaderAccessor로 메세지 헤더에 접근해서 웹소켓세션에 참여자의 정보를 저장? 사용?
                               SimpMessageHeaderAccessor headerAccessor) {

        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender()); //유저네임을 세션에 저장.
        return chatMessage;
    }
}