package com.drone.drone.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public interface SetCommand extends Command {

    Logger logger = LoggerFactory.getLogger(SetCommand.class);

    @Getter
    @AllArgsConstructor
    enum DetectionDirection {
        DOWN(0), FORWARD(1), BOTH(2);
        private final Integer code;
    }

    default DroneCommand speed(Integer speed) throws IOException {
        String command = "speed " + speed;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand rc(Integer a, Integer b, Integer c, Integer d) throws IOException {
        String command = "rc " + a + " " + b + " " + c + " " + d;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand wifi(String ssid, String pass) throws IOException {
        String command = "wifi " + ssid + " " + pass;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand mon() throws IOException {
        String command = "mon";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand moff() throws IOException {
        String command = "moff";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand mdirection(DetectionDirection direction) throws IOException {
        String command = "mdirection " + direction.getCode();
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand ap(String ssid, String pass) throws IOException {
        String command = "ap " + ssid + " " + pass;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }
}
