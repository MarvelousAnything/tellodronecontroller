package com.drone.drone.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "drone")
public class DroneProperties {

    @Getter
    @Setter
    public static class Server {
        private String address;
        private int commandPort;
        private int statePort;
        private int videoPort;
    }

    private Server server;

}
