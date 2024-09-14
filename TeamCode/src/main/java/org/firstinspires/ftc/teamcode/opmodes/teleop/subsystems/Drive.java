package org.firstinspires.ftc.teamcode.opmodes.teleop.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.config.Hardware;

public class Drive {
    private Hardware hardware;
    private Gamepad gamepad1;

    public Drive(Hardware hardware, Gamepad gamepad1) {
        this.hardware = hardware;
        this.gamepad1 = gamepad1;
    }

    public void move() {
        // Mecanum
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;

        // Strafing
        double fL = Range.clip(drive + strafe + turn, -0.5, 0.5);
        double fR = Range.clip(drive - strafe - turn, -0.5, 0.5);
        double bL = Range.clip(drive - strafe + turn, -0.5, 0.5);
        double bR = Range.clip(drive + strafe - turn, -0.5, 0.5);

        double rapidMode = 1.75;
        double sniperMode = 0.25;

        // Sniper mode
        if (gamepad1.left_trigger > 0) {
            hardware.fL.setPower(fL * rapidMode * sniperMode);
            hardware.fR.setPower(fR * rapidMode * sniperMode);
            hardware.bL.setPower(bL * rapidMode * sniperMode);
            hardware.bR.setPower(bR * rapidMode * sniperMode);
        }
        // Brakes
        else if (gamepad1.right_trigger > 0) {
            hardware.fL.setPower(fL * 0);
            hardware.fR.setPower(fR * 0);
            hardware.bL.setPower(bL * 0);
            hardware.bR.setPower(bR * 0);

        }
        // Normal drive
        else {
            hardware.fL.setPower(fL * rapidMode);
            hardware.fR.setPower(fR * rapidMode);
            hardware.bL.setPower(bL * rapidMode);
            hardware.bR.setPower(bR * rapidMode);
        }
    }
}
