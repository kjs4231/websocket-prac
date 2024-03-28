//package com.last.websocketprac.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.last.websocketprac.dto.MsgRoom;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import javax.imageio.IIOException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class MsgService {
//    private final ObjectMapper objectMapper;
//    private Map<String, MsgRoom> msgRoom;
//
//    @PostConstruct
//    private void init(){
//        msgRoom = new LinkedHashMap<>();
//    }
//
//    public List<MsgRoom> findAllRoom(){
//        return new ArrayList<>(msgRoom.values());
//    }
//
//    public MsgRoom findById(String roomId){
//        return msgRoom.get(roomId);
//    }
//
//    public MsgRoom createRoom(String name){
//        String roomId = name;
//        return MsgRoom.builder().roomId(roomId).build();
//    }
//
//    public <T> void sendMessage(WebSocketSession session, T meessage){
//
//        try {
//            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(meessage)));
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//
//
//}
