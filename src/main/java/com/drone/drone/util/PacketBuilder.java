package com.drone.drone.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;

@Getter
@Component
public class PacketBuilder {

    private static InetAddress droneAddress;

    private static EnumMap<PortType, Integer> portMap;

    @Autowired
    public PacketBuilder(InetAddress address, EnumMap<PortType, Integer> map) {
        droneAddress = address;
        portMap = map;
    }

    @Builder
    public static DatagramPacket newPacket(byte[] msg, PortType type) {
        return new DatagramPacket(msg, msg.length, droneAddress, portMap.get(type));
    }
}
