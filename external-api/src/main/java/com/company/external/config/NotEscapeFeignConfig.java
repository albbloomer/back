package com.company.external.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.codec.Encoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotEscapeFeignConfig {

    @Bean
    public Encoder feignEncoder() {
        JsonFactory factory = new JsonFactory();
        factory.configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), false); // HTML 태그가 escape되지 않도록 설정
        ObjectMapper mapper = new ObjectMapper(factory);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return new JacksonEncoder(mapper);
    }
}
