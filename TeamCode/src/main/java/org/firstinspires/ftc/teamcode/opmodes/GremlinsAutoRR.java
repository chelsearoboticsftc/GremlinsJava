package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class GremlinsAutoRR extends LinearOpMode {

    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Pose2d startPose = new Pose2d(10, -8, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //actual auto

        //move away from wall
        Trajectory traj1 = drivetrain.trajectoryBuilder(new Pose2d())
                .forward(0.5)
                .build();

        //park
        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeLeft(20)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);






    }
}

