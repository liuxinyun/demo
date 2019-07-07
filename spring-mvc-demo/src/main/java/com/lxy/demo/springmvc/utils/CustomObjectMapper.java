package com.lxy.demo.springmvc.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author liuxinyun
 * @date 2019/7/7 19:57
 */
public class CustomObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = -110213046894553459L;

    public CustomObjectMapper(){
        super();
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString("");
            }
        });
    }

}
