/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 19/08/2021 2:54 PM 
*/
package com.facenet.chatappwebservice.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDto {

    private String id;
    private String fkMessage;
    private String path;
    private String name;
}
