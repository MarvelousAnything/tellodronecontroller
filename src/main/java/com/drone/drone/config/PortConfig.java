package com.drone.drone.config;

import com.drone.drone.util.PortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;

@Configuration
@AllArgsConstructor
public class PortConfig {

    DroneProperties droneProperties;

    @Bean
    @Qualifier("portMap")
    public EnumMap<PortType, Integer> portMap() {
        EnumMap<PortType, Integer> map = new EnumMap<>(PortType.class);
        map.put(PortType.COMMAND, droneProperties.getServer().getCommandPort());
        map.put(PortType.STATE, droneProperties.getServer().getStatePort());
        map.put(PortType.VIDEO, droneProperties.getServer().getVideoPort());
        return map;
    }

}
