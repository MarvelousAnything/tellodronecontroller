package com.drone.drone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = DroneApplication.class)
@TestPropertySource("classpath:droneproperties-test.properties")
class DroneApplicationTests {

    @Test
    void contextLoads() {
    }

}
