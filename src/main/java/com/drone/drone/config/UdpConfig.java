package com.drone.drone.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.*;

@Getter
@Configuration
@ConfigurationProperties(prefix = "drone")
public class UdpConfig {

    private static class Server {
        public String address;
        public int commandPort;
        public int statePort;
        public int videoPort;
    }

    private Server server;

    @Bean
    @Qualifier("droneAddress")
    public InetAddress droneAddress() throws UnknownHostException {
        return InetAddress.getByName(server.address);
    }

    @Bean
    @Qualifier("commandSocket")
    public DatagramSocket commandSocket(@Autowired InetAddress droneAddress) throws SocketException {
        return new DatagramSocket(server.commandPort, droneAddress);
    }

    @Bean
    @Qualifier("stateSocket")
    public DatagramSocket stateSocket(@Autowired InetAddress droneAddress) throws SocketException {
        return new DatagramSocket(server.statePort, droneAddress);
    }

    @Bean
    @Qualifier("videoSocket")
    public DatagramSocket videoSocket(@Autowired InetAddress droneAddress) throws SocketException {
        return new DatagramSocket(server.videoPort, droneAddress);
    }

}
