package com.aline.accountmicroservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class AccountMicroserviceConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
