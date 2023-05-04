package com.os.os.Config;

import com.os.os.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String dll;

    @Bean
    public boolean instanciaDB(){
    if (dll.equals("create")){
        this.dbService.instanciaDB();
    }
    return false;

    }
}
