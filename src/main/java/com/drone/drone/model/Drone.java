package com.drone.drone.model;

import com.drone.drone.command.ControlCommand;
import com.drone.drone.command.DroneCommand;
import com.drone.drone.command.SetCommand;
import com.drone.drone.socket.DroneSocket;
import lombok.AllArgsConstructor;

import java.io.IOException;

public class Drone extends DroneCommand {


    public Drone(DroneSocket commandSocket) throws IOException {
        super(commandSocket);
        this.command();
    }
}
