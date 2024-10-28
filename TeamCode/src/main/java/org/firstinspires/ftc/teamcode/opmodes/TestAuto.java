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
                .forward(100) //Stafe Right delay on back wheels
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(startPose)
                .strafeRight(100) //Forward
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                .back(100)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(startPose)
                .forward(100)
                .build();

        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                .strafeLeft(100)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
       drivetrain.followTrajectory(traj5);







    }
}