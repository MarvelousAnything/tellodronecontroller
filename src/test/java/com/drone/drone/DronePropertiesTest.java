package com.drone.drone;

import com.drone.drone.config.DroneProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(classes = DroneApplication.class)
@TestPropertySource("classpath:droneproperties-test.properties")
public class DronePropertiesTest {

    @Autowired
    private DroneProperties properties;

    @Test
    public void whenNestedPropertyQueriedThenReturnsPropertyValue() {
        Assertions.assertEquals("0.0.0.0", properties.getServer().getAddress(),
                "Incorrectly bound Server Address nested property");
        log.info("Server Address nested property");
        Assertions.assertEquals(8889, properties.getServer().getCommandPort(),
                "Incorrectly bound Server Command Port nested property");
        log.info("Server Command Port nested property");
        Assertions.assertEquals(8890, properties.getServer().getStatePort(),
                "Incorrectly bound Server State Port nested property");
        log.info("Server State Port nested property");
        Assertions.assertEquals(11111, properties.getServer().getVideoPort(),
                "Incorrectly bound Server Video Port nested property");
        log.info("Server Video Port nested property");
    }

}
