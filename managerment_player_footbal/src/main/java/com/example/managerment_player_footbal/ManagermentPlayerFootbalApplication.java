package com.example.managerment_player_footbal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagermentPlayerFootbalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagermentPlayerFootbalApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
