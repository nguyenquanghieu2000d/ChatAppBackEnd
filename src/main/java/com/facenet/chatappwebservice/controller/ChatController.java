/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 19/08/2021 11:24 AM 
*/
package com.facenet.chatappwebservice.controller;

import com.facenet.chatappwebservice.config.AllowHost;
import com.facenet.chatappwebservice.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Quản lý tất cả những thứ liên quan đến chat giữ các user với nhau
 */

@RestController
@CrossOrigin(origins = AllowHost.host, allowedHeaders = "*")
@RequestMapping(path = "api/chat")
public class ChatController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {

        this.chatService = chatService;
    }

    /**
     * Lấy toàn bộ message trong database, tin nhắn trò chuyện giữa 2 người, không có phân trang
     *
     * @param user1
     * @param user2
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllMessageAndFileForm2User(@RequestParam String user1, @RequestParam String user2) {

        LOGGER.info("Get all user");
        return new ResponseEntity<>(chatService.getAllMessageAndFileForm2User(user1, user2), HttpStatus.OK);
    }

    /**
     * Lấy message trong cơ sở dữ liệu dựa vào id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<?> getMessageById(@PathVariable("id") String id) {

        LOGGER.info("Get user by id");
        return new ResponseEntity<>(chatService.getMessageById(id), HttpStatus.OK);
    }
}
