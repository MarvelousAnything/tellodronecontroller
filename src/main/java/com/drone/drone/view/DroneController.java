package com.drone.drone.view;

import com.drone.drone.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.IOException;

@Component
public class DroneController {
    private JButton takeOffButton;
    private JButton landButton;
    private JButton disconnectButton;
    private JPanel contentPane;

    private final Drone drone;

    @Autowired
    public DroneController(Drone drone) {
        this.drone = drone;

        takeOffButton.addActionListener(e -> {
            try {
                this.drone.takeoff();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        landButton.addActionListener(e -> {
            try {
                this.drone.land();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        disconnectButton.addActionListener(e -> {
            onDisconnect();
        });
    }

    private void onDisconnect() {
        this.drone.disconnect();
    }


}
