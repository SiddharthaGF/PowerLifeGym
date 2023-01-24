package com.jpgl.powerlifegym;

import com.jpgl.powerlifegym.logic.validation.PersonValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class PowerLifeGymApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerLifeGymApplication.class, args);
    }
}
