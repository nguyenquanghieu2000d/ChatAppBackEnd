/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 19/08/2021 2:52 PM 
*/
package com.facenet.chatappwebservice.model.dto;


import com.facenet.chatappwebservice.entity.File;
import com.facenet.chatappwebservice.utilities.ObjectMapperUtils;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChatDto {


    private String id;
    private String fromacc;
    private String toacc;
    private String message;
    private Timestamp date;
    private Collection<FileDto> filesById;
    private Boolean isMyMessage;

//    public ChatDto(String id, String fromacc, String toacc, String message, Timestamp date, Collection<File> filesById) {
//        this.id = id;
//        this.fromacc = fromacc;
//        this.toacc = toacc;
//        this.message = message;
//        this.date = date;
//        this.filesById = filesById.stream().map(chat -> mapper.map(chat, FileDto.class)).collect(Collectors.toList());
//    }
}
