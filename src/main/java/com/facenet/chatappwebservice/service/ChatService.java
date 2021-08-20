/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 11/08/2021 9:43 PM 
*/
package com.facenet.chatappwebservice.service;

import com.facenet.chatappwebservice.entity.Chat;
import com.facenet.chatappwebservice.model.dto.ChatDto;
import com.facenet.chatappwebservice.repository.ChatRepository;
import com.facenet.chatappwebservice.utilities.ObjectMapperUtils;
import lombok.Data;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@Setter
public class ChatService {

    private ObjectMapperUtils mapper;

    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatService, ObjectMapperUtils mapper) {

        this.chatRepository = chatService;
        this.mapper = mapper;
    }

    public List<ChatDto> getAllMessageAndFileForm2User(String user1, String user2) {

        List<Chat> chatList = chatRepository.getChatFrom2User(user1, user2);
        return mapper.mapAll(chatList, ChatDto.class);
    }

    public List<Chat> getChat() {
        Chat user = chatRepository.getById("quanghieu333");
        return List.of(user);
    }

    public ChatDto getMessageById(String id) {

        Chat chat = chatRepository.getById(id);
        return mapper.map(chat, ChatDto.class);
    }
}
