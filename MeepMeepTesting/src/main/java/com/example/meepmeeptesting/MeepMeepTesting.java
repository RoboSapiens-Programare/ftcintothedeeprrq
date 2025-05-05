package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(25, -60, Math.toRadians(-90)))
                .strafeToConstantHeading(new Vector2d(0, -33))
                .strafeToLinearHeading(new Vector2d(35,-40), Math.toRadians(45))
                .strafeToLinearHeading(new Vector2d(45,-40), Math.toRadians(-90))
                .turnTo(Math.toRadians(45))
                .strafeToLinearHeading(new Vector2d(55,-40), Math.toRadians(-90))
                .turnTo(Math.toRadians(45))

                //.turnTo(Math.toRadians(-90))

                // goes directly to the pickup position presuming that the robot leaves the third sample there with the intake down
                .strafeToLinearHeading(new Vector2d(47,-55), Math.toRadians(-90))

                // 1
                .strafeToConstantHeading(new Vector2d(0, -33))
                // 2
                .strafeToConstantHeading(new Vector2d(47,-55))
                .strafeToConstantHeading(new Vector2d(0, -33))
                // 3
                .strafeToConstantHeading(new Vector2d(47,-55))
                .strafeToConstantHeading(new Vector2d(0, -33))
                // 4
                .strafeToConstantHeading(new Vector2d(47,-55))
                .strafeToConstantHeading(new Vector2d(0, -33))
                // 5
                .strafeToConstantHeading(new Vector2d(47,-55))
                .strafeToConstantHeading(new Vector2d(0, -33))
                // park with extended intake while trying to go to observation zone
                .strafeToLinearHeading(new Vector2d(47,-55), Math.toRadians(-45))


                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}