package com.itexcellence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class ItexcellenceApplication {

    private static final Logger LOGGER = LogManager.getLogger(ItexcellenceApplication.class);

    public static void main(String[] args) {

//        LOGGER.info("Info level logging");
//        LOGGER.debug("Debugging.....");
//        LOGGER.error("ALERT------ERROR");
        SpringApplication.run(ItexcellenceApplication.class, args);
    }
}
