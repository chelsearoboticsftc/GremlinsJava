package org.firstinspires.ftc.teamcode.opmodes;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class GremlinsAutoBR extends LinearOpMode {
    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();



        //actual auto

        //push sample
        Trajectory strafeLeft = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                .strafeLeft(22)
                .build();
        drivetrain.followTrajectory(strafeLeft);

        //move away from sample
        Trajectory strafeRight = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                .strafeRight(2)
                .build();
        drivetrain.followTrajectory(strafeRight);

        //park
        Trajectory goForward = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                .forward(23)
                .build();
        drivetrain.followTrajectory(goForward);

        drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                .strafeRight(104)
                .build();
        drivetrain.followTrajectory(strafeRight);

        Trajectory back = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                .back(17)
                .build();
        drivetrain.followTrajectory(back);



    }
}

 /*  Trajectory goForward = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                    .forward(100)
                    .build();
            drivetrain.followTrajectory(goForward);

            Trajectory lineToPosition = drivetrain.trajectoryBuilder(new Pose2d(10, 0, 0))
                    .lineTo(new Vector2d(0, 0))
                    .build();
            drivetrain.followTrajectory(lineToPosition);


            Trajectory strafeLeft = drivetrain.trajectoryBuilder(new Pose2d(0, 0, 0))
                    .strafeLeft(50)
                    .build();
            drivetrain.followTrajectory(strafeLeft);

            Trajectory strafeToPosition = drivetrain.trajectoryBuilder(new Pose2d(0, 0))
                    .strafeTo(new Vector2d(0, 50))
                    .build();
            drivetrain.followTrajectory(strafeToPosition);*/

