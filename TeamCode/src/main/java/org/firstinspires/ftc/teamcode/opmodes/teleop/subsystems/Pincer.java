package org.firstinspires.ftc.teamcode.opmodes.teleop.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.config.Hardware;

public class Pincer {
    private Hardware hardware;
    private Gamepad gamepad2;
    private boolean pincerToggle = false;
    private double PINCER_OPEN = 1;
    private double PINCER_CLOSE = 0;
    private boolean pincerTwistToggle = false;
    private double PINCER_TWIST_90 = 0.5;
    private double PINCER_TWIST_0 = 0;

    public Pincer(Hardware hardware, Gamepad gamepad2) {
        this.hardware = hardware;
        this.gamepad2 = gamepad2;
    }

    public void pince(Gamepad currentGamepad2, Gamepad previousGamepad2) {
        try {
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);
        } catch (Exception e) {}

        if (currentGamepad2.a && !previousGamepad2.a) {
            pincerToggle = !pincerToggle;
        }

        if (pincerToggle) {
            hardware.pincer.setPosition(PINCER_CLOSE);
        } else {
            hardware.pincer.setPosition(PINCER_OPEN);
        }
    }

    // Twist Pincer Horizontally
    public void twist(Gamepad currentGamepad2, Gamepad previousGamepad2) {
        try {
            previousGamepad2.copy(currentGamepad2);
            currentGamepad2.copy(gamepad2);
        } catch (Exception e) {}

        if (currentGamepad2.b && !previousGamepad2.b) {
            pincerTwistToggle = !pincerTwistToggle;
        }

        if (pincerTwistToggle) {
            hardware.pincerTwister.setPosition(PINCER_TWIST_90);
        } else {
            hardware.pincerTwister.setPosition(PINCER_TWIST_0);
        }
    }

    // Rotate Pincer Vertically
    public void rotate() {
        if (gamepad2.left_trigger > 0.75) {
            hardware.pincerRotatorR.setPosition(hardware.pincerRotatorR.getPosition()-0.01);
            hardware.pincerRotatorL.setPosition(hardware.pincerRotatorL.getPosition()-0.01);
        } else if (gamepad2.right_trigger > 0.75) {
            hardware.pincerRotatorR.setPosition(hardware.pincerRotatorR.getPosition()+0.01);
            hardware.pincerRotatorL.setPosition(hardware.pincerRotatorL.getPosition()+0.01);
        }
    }
}
