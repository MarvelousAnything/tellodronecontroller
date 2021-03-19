package com.drone.drone.socket;

import java.io.IOException;
import java.net.DatagramPacket;

public interface DroneSocket {

    void send(DatagramPacket packet) throws IOException;

    void receive(DatagramPacket packet) throws IOException;

    void receive() throws IOException;

    DatagramPacket getRecvPacket();
}

