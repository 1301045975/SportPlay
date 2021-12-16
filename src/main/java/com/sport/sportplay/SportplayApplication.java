package com.sport.sportplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.sport.sportplay.dao")
public class SportplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportplayApplication.class, args);
    }

}
