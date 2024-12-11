package org.firstinspires.ftc.teamcode.opmodes.teleop.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.Hardware;

public class Arm {
    private Hardware hardware;
    private Telemetry telemetry;
    private Gamepad gamepad2;

    public Arm(Hardware hardware, Telemetry telemetry, Gamepad gamepad2) {
        this.hardware = hardware;
        this.telemetry = telemetry;
        this.gamepad2 = gamepad2;
    }

    public void extend() {
        hardware.armExtender.setPower(-0.75*gamepad2.right_stick_y);
    }

    public void rotate() {
        hardware.armRotator.setPower(0.75*gamepad2.left_stick_y);
    }
}
