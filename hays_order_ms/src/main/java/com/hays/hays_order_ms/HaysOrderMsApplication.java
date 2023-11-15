package com.hays.hays_order_ms;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HaysOrderMsApplication {


    public static void main(String[] args) {
        SpringApplication.run(HaysOrderMsApplication.class, args);
    }

}
