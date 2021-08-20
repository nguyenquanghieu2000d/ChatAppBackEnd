/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 19/08/2021 3:45 PM 
*/
package com.facenet.chatappwebservice.config;

import com.facenet.chatappwebservice.service.ChatService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.facenet.chatappwebservice"})
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
