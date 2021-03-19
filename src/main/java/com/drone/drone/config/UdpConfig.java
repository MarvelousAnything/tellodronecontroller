package com.drone.drone.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.*;

@Configuration
@AllArgsConstructor
public class UdpConfig {

    private final DroneProperties properties;

    @Bean
    @Qualifier("droneAddress")
    public InetAddress droneAddress() throws UnknownHostException {
        return InetAddress.getByName(properties.getServer().getAddress());
    }

    @Bean
    @Scope("prototype")
    @Qualifier("recvPacket")
    public DatagramPacket recvSocket() {
        return new DatagramPacket(new byte[256], 256);
    }
}
