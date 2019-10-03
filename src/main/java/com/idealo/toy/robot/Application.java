package com.idealo.toy.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Jacob
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main( String[] args ){
    	SpringApplication.run(Application.class, args);
    }
}
