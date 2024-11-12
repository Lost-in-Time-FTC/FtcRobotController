package org.firstinspires.ftc.teamcode.opmodes.teleop.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.config.Hardware;

public class Arm {
    private Hardware hardware;
    private Gamepad gamepad2;

    public Arm(Hardware hardware, Gamepad gamepad2) {
        this.hardware = hardware;
        this.gamepad2 = gamepad2;
    }

    public void extend() {
        hardware.armExtender.setPower(gamepad2.right_stick_y);
    }

    public void rotate() {
        hardware.armRotator.setPower(gamepad2.left_stick_y);
    }
}
