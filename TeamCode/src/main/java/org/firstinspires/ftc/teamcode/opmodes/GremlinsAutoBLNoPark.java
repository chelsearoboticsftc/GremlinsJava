package org.firstinspires.ftc.teamcode.opmodes;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class GremlinsAutoBLNoPark extends LinearOpMode {
    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Pose2d startPose = new Pose2d(39.5,62,Math.toRadians(270));

        drivetrain.setPoseEstimate(startPose);

        //actual auto

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                //Push Sample
                .strafeLeft(22)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeRight(12)
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                //Move Away From Wall
                .forward(12)
                .build();



        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);



    }
}

