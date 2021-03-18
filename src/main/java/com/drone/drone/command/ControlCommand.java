package com.drone.drone.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public interface ControlCommand extends Command {

    Logger logger = LoggerFactory.getLogger(ControlCommand.class);

    @Getter
    @AllArgsConstructor
    enum Direction {
        LEFT("l"),
        RIGHT("r"),
        FORWARD("f"),
        BACK("b");

        private final String code;
    }

    default DroneCommand command() throws IOException {
        String command = "Command";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand takeoff() throws IOException {
        String command = "takeoff";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand land() throws IOException {
        String command = "land";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand streamon() throws IOException {
        String command = "streamon";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand streamoff() throws IOException {
        String command = "streamoff";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand emergency() throws IOException {
        String command = "emergency";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand up(Integer distance) throws IOException {
        String command = "up " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand down(Integer distance) throws IOException {
        String command = "down " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand left(Integer distance) throws IOException {
        String command = "left " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand right(Integer distance) throws IOException {
        String command = "right " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand forward(Integer distance) throws IOException {
        String command = "forward " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand back(Integer distance) throws IOException {
        String command = "back " + distance;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand cw(Integer angle) throws IOException {
        String command = "cw " + angle;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand ccw(Integer angle) throws IOException {
        String command = "ccw " + angle;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand flip(Direction direction) throws IOException {
        String command = "flip " + direction.getCode();
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand go(Integer x, Integer y, Integer z, Integer speed) throws IOException {
        String command = "go " + x + " " + y + " " + z + " " + speed;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand stop() throws IOException {
        String command = "stop";
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand curve(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2, Integer speed) throws IOException {
        String command = "curve " + x1 + " " + y1 + " " + z1 + " " + x2 + " " + y2 + " " + z2 + " " + speed;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand go(Integer x, Integer y, Integer z, Integer speed, String mid) throws IOException {
        String command = "go " + x + " " + y + " " + z + " " + speed + " " + mid;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand curve(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2, Integer speed, String mid) throws IOException {
        String command = "curve " + x1 + " " + y1 + " " + z1 + " " + x2 + " " + y2 + " " + z2 + " " + speed + " " + mid;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }

    default DroneCommand jump(Integer x, Integer y, Integer z, Integer speed, Integer yaw, String mid1, String mid2) throws IOException {
        String command = "go " + x + " " + y + " " + z + " " + speed + " " + yaw + " " + mid1 + " " + mid2;
        logger.info("Sending command: " + command);
        return this.sendCommand(command);
    }
}
