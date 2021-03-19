package com.drone.drone.model;

import com.drone.drone.command.ControlCommand;
import com.drone.drone.command.DroneCommand;
import com.drone.drone.command.SetCommand;
import com.drone.drone.socket.DroneSocket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Drone extends DroneCommand {
    public Drone(DroneSocket commandSocket, DroneSocket stateSocket) throws IOException {
        super(commandSocket, stateSocket);
        this.command();
    }

    public void disconnect() {
        this.getCommandSocket().disconnect();
        this.getStateSocket().disconnect();
    }
}
