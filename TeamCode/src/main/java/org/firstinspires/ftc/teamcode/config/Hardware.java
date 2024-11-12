package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@SuppressWarnings("unused")
public class Hardware {
    public DcMotor fL;
    public DcMotor fR;
    public DcMotor bL;
    public DcMotor bR;
    public DcMotor armExtender;
    public DcMotor armRotator;
    public Servo pincerRotatorL;
    public Servo pincerRotatorR;
    public Servo pincerTwister;
    public Servo pincer;

    public Hardware(HardwareMap hardwareMap) {
        fR = hardwareMap.get(DcMotor.class, "fR");
        fL = hardwareMap.get(DcMotor.class, "fL");
        bR = hardwareMap.get(DcMotor.class, "bR");
        bL = hardwareMap.get(DcMotor.class, "bL");
        armExtender = hardwareMap.get(DcMotor.class, "armExtender");
        armRotator = hardwareMap.get(DcMotor.class, "armRotator");
        pincerRotatorL = hardwareMap.get(Servo.class, "pincerRotatorL");
        pincerRotatorR = hardwareMap.get(Servo.class, "pincerRotatorR");
        pincerTwister = hardwareMap.get(Servo.class, "pincerTwister");
        pincer = hardwareMap.get(Servo.class, "pincer");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        bL.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.FORWARD);
        fL.setDirection(DcMotor.Direction.REVERSE);
        fR.setDirection(DcMotor.Direction.FORWARD);
    }

    public void driveForwardTime(double power, int time) throws InterruptedException {
        bL.setPower(power);
        bR.setPower(power);
        fL.setPower(power);
        fR.setPower(power);
        Thread.sleep(time);
        bL.setPower(0);
        bR.setPower(0);
        fL.setPower(0);
        fR.setPower(0);
    }

    public void driveBackwardTime(double power, int time) throws InterruptedException {
        bL.setPower(-power);
        bR.setPower(-power);
        fL.setPower(-power);
        fR.setPower(-power);
        Thread.sleep(time);
        bL.setPower(0);
        bR.setPower(0);
        fL.setPower(0);
        fR.setPower(0);
    }

    public void driveRightTime(double power, int time) throws InterruptedException {
        bL.setPower(-power);
        bR.setPower(power);
        fL.setPower(power);
        fR.setPower(-power);
        Thread.sleep(time);
        bL.setPower(0);
        bR.setPower(0);
        fL.setPower(0);
        fR.setPower(0);
    }

    public void driveLeftTime(double power, int time) throws InterruptedException {
        bL.setPower(power);
        bR.setPower(-power);
        fL.setPower(-power);
        fR.setPower(power);
        Thread.sleep(time);
        bL.setPower(0);
        bR.setPower(0);
        fL.setPower(0);
        fR.setPower(0);
    }
}
