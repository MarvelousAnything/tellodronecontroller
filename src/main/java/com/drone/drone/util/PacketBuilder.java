package com.drone.drone.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.InetAddress;

@Getter
@Component
public class PacketBuilder {

    private static InetAddress droneAddress;

    @Autowired
    public PacketBuilder(InetAddress address) {
        droneAddress = address;
    }

    @Builder
    public static DatagramPacket newPacket(byte[] msg, int port) {
        return new DatagramPacket(msg, msg.length, droneAddress, port);
    }

    @Builder
    public static DatagramPacket newPacket(byte[] msg) {
        return new DatagramPacket(msg, msg.length);
    }

}
