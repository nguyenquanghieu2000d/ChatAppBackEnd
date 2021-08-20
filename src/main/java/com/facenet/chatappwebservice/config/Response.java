/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 13/08/2021 2:19 PM 
*/
package com.facenet.chatappwebservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private HttpStatus status;
    private String message;
}
