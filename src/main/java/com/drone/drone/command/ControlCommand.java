package com.drone.drone.command;

import java.io.IOException;

public interface ControlCommand extends Command {

    default DroneCommand command() throws IOException {
        String msg = "Command";
        return (DroneCommand) this.sendCommand(msg);
    }
}
