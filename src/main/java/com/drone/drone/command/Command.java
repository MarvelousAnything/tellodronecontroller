package com.drone.drone.command;

import com.drone.drone.socket.DroneSocket;
import com.drone.drone.util.PacketBuilder;
import com.drone.drone.util.PortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public interface Command {

    DroneSocket getSocket();

    default DroneCommand sendCommand(String command) throws IOException {
        this.getSocket().send(
                PacketBuilder.builder()
                        .type(PortType.COMMAND)
                        .msg(command.getBytes(StandardCharsets.UTF_8))
                        .build());
        return (DroneCommand) this;
    }

}
