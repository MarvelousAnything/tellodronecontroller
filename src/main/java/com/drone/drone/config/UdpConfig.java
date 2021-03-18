package com.drone.drone.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

@Configuration
@AllArgsConstructor
public class UdpConfig {

    private final DroneProperties properties;

    @Bean
    @Qualifier("droneAddress")
    public InetAddress droneAddress() throws UnknownHostException {
        return InetAddress.getByName(properties.getServer().getAddress());
    }
}
