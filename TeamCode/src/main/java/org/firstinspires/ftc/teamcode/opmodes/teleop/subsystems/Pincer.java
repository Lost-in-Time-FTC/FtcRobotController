package org.firstinspires.ftc.teamcode.opmodes.teleop.subsystems;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.Hardware;

public class Pincer {
    private Hardware hardware;
    private Telemetry telemetry;
    private Gamepad gamepad2;
    private boolean pincerToggle = false;
    private double PINCER_OPEN = 0;
    private double PINCER_CLOSE = 1;
    private boolean pincerTwistToggle = false;
    private double PINCER_TWIST_90 = 0.5;
    private double PINCER_TWIST_0 = 0;

    public Pincer(Hardware hardware, Telemetry telemetry, Gamepad gamepad2) {
        this.hardware = hardware;
        this.telemetry = telemetry;
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

    //Rotate Pincer Vertically Take 2
    public void rotate() {
        if (gamepad2.b) {
            hardware.pincerRotatorR.setPosition(1);
        } else if (gamepad2.x) {
            hardware.pincerRotatorR.setPosition(0.5);
        }
    }
    // Rotate Pincer Vertically
//    public void rotate(Gamepad currentGamepad2, Gamepad previousGamepad2) {
//        try {
//            previousGamepad2.copy(currentGamepad2);
//            currentGamepad2.copy(gamepad2);
//        } catch (Exception e) {}
//
//        if (currentGamepad2.b && !previousGamepad2.b) {
//            pincerTwistToggle = !pincerTwistToggle;
//        }
//
//        if (pincerTwistToggle) {
//            hardware.pincerRotatorR.setPosition(1);
//            hardware.pincerRotatorL.setPosition(1);
//        } else {
//            hardware.pincerRotatorR.setPosition(.5);
//            hardware.pincerRotatorL.setPosition(.5);
//        }
//    }

    // Twist Pincer Horizontally
    public void twist() {
        if (gamepad2.left_trigger > 0.75) {
            hardware.pincerTwister.setPosition(hardware.pincerTwister.getPosition()-0.01);
        } else if (gamepad2.right_trigger > 0.75) {
            hardware.pincerTwister.setPosition(hardware.pincerTwister.getPosition()+0.01);
        }
    }
}
