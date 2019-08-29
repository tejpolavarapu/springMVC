//Non-functional : tried to replace the person_dispatcher-servlet.xml file using java configuration
/*package com.test.pluto.configuration;

import com.google.gson.Gson;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.net.UnknownHostException;

@Configuration
@EnableWebMvc
@ComponentScan("com.test.pluto")
public class PersonDispatcherConfig extends WebMvcConfigurationSupport {




    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost:27017");
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }
}*/
