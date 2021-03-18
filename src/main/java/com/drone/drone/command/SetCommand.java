package com.drone.drone.command;

import java.io.IOException;

public interface SetCommand extends Command {


    default DroneCommand up(Integer distance) throws IOException {
        String command = "up " + distance;
        return (DroneCommand) this.sendCommand(command);
    }
}
