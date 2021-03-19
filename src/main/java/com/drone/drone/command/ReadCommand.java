package com.drone.drone.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public interface ReadCommand extends Command {

    Logger logger = LoggerFactory.getLogger(ReadCommand.class);

    default DroneCommand speed() throws IOException {
        String command = "speed?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "Speed");
    }

    default DroneCommand battery() throws IOException {
        String command = "battery?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "Battery");
    }

    default DroneCommand time() throws IOException {
        String command = "time?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "Time");
    }

    default DroneCommand wifi() throws IOException {
        String command = "wifi?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "snr");
    }

    default DroneCommand sdk() throws IOException {
        String command = "sdk?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "sdk version");
    }

    default DroneCommand sn() throws IOException {
        String command = "sn?";
        logger.info("Sending command: " + command);
        return this.sendAndRecvState(command, logger, "serial number");
    }

}
