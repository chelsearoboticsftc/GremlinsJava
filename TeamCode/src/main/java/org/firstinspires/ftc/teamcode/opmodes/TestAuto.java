package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;


@Autonomous
public class TestAuto extends LinearOpMode {

    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Pose2d startPose = new Pose2d(10, -5);

        drivetrain.setPoseEstimate(startPose);

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                .forward(10)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeRight(10) //Forward
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                .back(10)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(traj3.end())
                .strafeLeft(10)
                .build();

        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                .forward(10)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
       drivetrain.followTrajectory(traj5);

        /**
         * Hello Gremlins of the future this is Olivia of 8th grade, Jane 6th and kind
         * of 7th grade because math, Lily of 6th grade, and Lucy of 8th grade we are the
         * 2024-2025 gremlins Programmers. This is a test program we wrote so that the
         * Auton doesn't go explodey. and so Jane doesn't go dead. and so that Olivia
         * Doesn't Explode and go dead because things broke and we only have 5 min to fix in between
         * matches. and so Lily Doesn't cry and die because things broken! WE ARE INSANE AND AMAZING GREMLIN
         * PROGRAMMERS OF THE PAST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */








    }
}