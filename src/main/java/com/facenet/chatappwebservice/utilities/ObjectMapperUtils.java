/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 19/08/2021 4:36 PM 
*/
package com.facenet.chatappwebservice.utilities;

import com.facenet.chatappwebservice.model.dto.ChatDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ObjectMapperUtils {

    private final ModelMapper mapper;

    @Autowired
    public ObjectMapperUtils(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <D,T> List<D> mapAll(final Collection <T> entityList, Class<D> outClass) {

        return entityList.stream().map(chat -> mapper.map(chat, outClass)).collect(Collectors.toList());
    }

    public <D,T> D map(final T entity, Class<D> outClass) {

        return mapper.map(entity, outClass);
    }

    public <S, D> D map(final S source, D destination) {

        mapper.map(source, destination);
        return destination;
    }

}
