package com.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.restservice.service.CurrencyExchangeClient;

/**
 * Created by Igor on 09.01.2017.
 */
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.restservice"})
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);



    }


}
