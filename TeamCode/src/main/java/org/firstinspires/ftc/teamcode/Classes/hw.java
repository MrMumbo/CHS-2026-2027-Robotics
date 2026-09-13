package org.firstinspires.ftc.teamcode.Classes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class hw extends OpMode {
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;

    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    }

    public void loop() {

    }
}