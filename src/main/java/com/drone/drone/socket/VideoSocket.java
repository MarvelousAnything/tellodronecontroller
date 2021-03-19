package com.drone.drone.socket;

import com.drone.drone.config.DroneProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@Getter
@Qualifier("videoSocket")
@Component("videoSocket")
public class VideoSocket extends DatagramSocket implements DroneSocket {

    private InetAddress droneAddress;
    private DroneProperties droneProperties;
    private final DatagramPacket recvPacket;

    @Autowired
    public VideoSocket(InetAddress droneAddress, DroneProperties droneProperties, DatagramPacket recvPacket) throws SocketException {
        super(droneProperties.getServer().getVideoPort(), droneAddress);
        this.recvPacket = recvPacket;
    }

    @Override
    public void send(DatagramPacket packet) throws IOException {
        super.send(packet);
    }

    @Override
    public void receive(DatagramPacket packet) throws IOException {
        super.receive(packet);
    }

    @Override
    public void receive() throws IOException {
        this.receive(recvPacket);
    }

    @PreDestroy
    public void preDestroy() {
        this.disconnect();
        this.close();
    }
}
