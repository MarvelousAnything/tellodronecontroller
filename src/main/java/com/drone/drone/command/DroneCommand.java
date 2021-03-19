package com.drone.drone.command;

import com.drone.drone.socket.DroneSocket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DroneCommand implements ControlCommand, SetCommand, ReadCommand {

    private final DroneSocket commandSocket;

    private final DroneSocket stateSocket;

    @Override
    public DroneSocket getCommandSocket() {
        return commandSocket;
    }

    @Override
    public DroneSocket getStateSocket() {
        return stateSocket;
    }
}
