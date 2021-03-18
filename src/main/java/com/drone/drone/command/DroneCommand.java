package com.drone.drone.command;

import com.drone.drone.socket.DroneSocket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DroneCommand implements ControlCommand, SetCommand, Command {

    private final DroneSocket commandSocket;

    @Override
    public DroneSocket getSocket() {
        return commandSocket;
    }
}
