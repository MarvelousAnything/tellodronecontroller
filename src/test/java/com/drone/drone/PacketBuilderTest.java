package com.drone.drone;

import com.drone.drone.util.PacketBuilder;
import com.drone.drone.util.PortType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest(classes = DroneApplication.class)
@TestPropertySource("classpath:droneproperties-test.properties")
public class PacketBuilderTest {

    private static final String testMessage = "Packet Builder Test Message";

    @Test
    public void whenNewPacketIsCreatedThenReturnsDatagramPacket() {
        DatagramPacket testPacket = PacketBuilder.builder()
                .msg(testMessage.getBytes(StandardCharsets.UTF_8))
                .type(PortType.COMMAND)
                .build();

        Assertions.assertNotNull(testPacket);
        log.info("Test Packet created: " + testPacket);
    }

}
