package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Classes.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Drive Logic", group="Teleop")
public class Drive extends OpMode {
    boolean DpDown= true;
    Hardware Hardware = new Hardware();

    @Override
    public void init() {
        Hardware.declareHardware(hardwareMap);
    }

    @Override
    public void loop() {
        // Button Toggles Logic
        if(gamepad1.dpad_down){DpDown = !DpDown;}

        if (DpDown) {
            Hardware.driveFieldRel(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        } else {
            Hardware.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
}
