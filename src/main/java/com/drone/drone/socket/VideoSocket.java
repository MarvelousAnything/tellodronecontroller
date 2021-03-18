package com.drone.drone.socket;

import com.drone.drone.config.DroneProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@Qualifier("videoSocket")
@Component("videoSocket")
public class VideoSocket extends DatagramSocket implements DroneSocket {

    private InetAddress droneAddress;
    private DroneProperties droneProperties;

    @Autowired
    public VideoSocket(InetAddress droneAddress, DroneProperties droneProperties) throws SocketException {
        super(droneProperties.getServer().getVideoPort(), droneAddress);
    }

    @PreDestroy
    public void preDestroy() {
        this.disconnect();
        this.close();
    }
}
