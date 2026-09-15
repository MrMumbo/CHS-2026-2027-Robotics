package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Classes.hw;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Drive Logic", group="Teleop")
public class Drive extends OpMode {
    boolean DpDown= true;
    hw hw = new hw();

    @Override
    public void init() {
        hw.declareHardware(hardwareMap);
    }

    @Override
    public void loop() {
        // Button Toggles Logic
        if(gamepad1.dpad_down){DpDown = !DpDown;}

        if (DpDown) {
            hw.driveFieldRel(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        } else {
            hw.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
}
