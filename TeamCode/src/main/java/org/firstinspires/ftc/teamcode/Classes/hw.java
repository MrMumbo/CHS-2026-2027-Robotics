package org.firstinspires.ftc.teamcode.Classes;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class hw {
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;
    public IMU imu;

    public void declareHardware(HardwareMap hwMap) {
        frontRight = hwMap.get(DcMotor.class, "frontRight");
        frontLeft = hwMap.get(DcMotor.class, "frontLeft");
        backRight = hwMap.get(DcMotor.class, "backRight");
        backLeft = hwMap.get(DcMotor.class, "backLeft");
        imu = hwMap.get(IMU.class, "imu");
        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
                RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new
                RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }

    public void drive(float x, float y, float r) {
        frontRight.setPower(x + y + r);
        frontLeft.setPower(x + y - r);
        backRight.setPower(x - y + r);
        backLeft.setPower(x - y - r);
    }

    public void driveFieldRel(float x, float y, float r) {
        float theta;
        float thetaRobot;
        float thetaDrive;
        float magnitude = (float) Math.hypot(y, x);

        thetaDrive = (float) Math.atan2(y,x);
        thetaRobot = (float) imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        theta = thetaDrive - thetaRobot;

        float uY = (float) Math.cos(theta) * magnitude;
        float uX = (float) Math.sin(theta) * magnitude;

        drive(uX, uY, r);
    }
}