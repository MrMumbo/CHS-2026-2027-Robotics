package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(61, 0, 3.14))
                        .forward(10)
                        .strafeLeft(15)
                        .strafeRight(38)
                        .turn(3.14)
                        .forward(10)
                        .back(10)
                        .turn(-3.14)
                        .strafeLeft(23)
                        .forward(100)
                        .strafeLeft(11)
                        .turn(3.14)
                        .turn(3.14)
                        .strafeLeft(11)
                        .forward(10)
                        .back(10)
                        .turn(3.14)
                        .strafeLeft(11)
                        .build());

        Image img = null;
        try {
            // Looks directly into the 'resources' folder on any device
            InputStream is = MeepMeepTesting.class.getClassLoader().getResourceAsStream("biobuzz.png");
            if (is != null) {
                img = ImageIO.read(is);
            } else {
                System.out.println("Error: biobuzz.png not found in resources folder!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert img != null;
        meepMeep.setBackground(img)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
