package com.drone.drone.command;

import com.drone.drone.socket.DroneSocket;
import com.drone.drone.util.PacketBuilder;
import com.drone.drone.util.PortType;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;

public interface Command {

    DroneSocket getCommandSocket();

    DroneSocket getStateSocket();

    default DroneCommand sendCommand(String command) throws IOException {
        this.getCommandSocket().send(
                PacketBuilder.builder()
                        .type(PortType.COMMAND)
                        .msg(command.getBytes(StandardCharsets.UTF_8))
                        .build());
        return (DroneCommand) this;
    }

    default DatagramPacket recvState() throws IOException {
        this.getStateSocket().receive();
        return this.getStateSocket().getRecvPacket();
    }

    default DroneCommand sendAndRecvState(String command, Logger logger) throws IOException {
        this.sendCommand(command);
        DatagramPacket responsePacket = this.recvState();
        String response = new String(responsePacket.getData(), responsePacket.getOffset(), responsePacket.getLength());
        logger.info("Tello responded to \"" + command + "\" with \"" + response + "\"");
        return (DroneCommand) this;
    }

    default DroneCommand sendAndRecvState(String command, Logger logger, String readValue) throws IOException {
        this.sendCommand(command);
        DatagramPacket responsePacket = this.recvState();
        String response = new String(responsePacket.getData(), responsePacket.getOffset(), responsePacket.getLength());
        logger.info(readValue + ": " + response);
        return (DroneCommand) this;
    }

}
