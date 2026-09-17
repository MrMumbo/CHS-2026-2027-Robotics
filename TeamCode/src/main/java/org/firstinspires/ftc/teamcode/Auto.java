package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Classes.Hardware;

public class Auto extends LinearOpMode {
    Hardware hw = new Hardware();

    public void runOpMode() {
        hw.driveTime(1, 1, 0, 1);
    }
}
