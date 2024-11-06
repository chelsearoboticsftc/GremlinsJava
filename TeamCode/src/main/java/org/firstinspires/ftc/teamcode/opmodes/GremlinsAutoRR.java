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


        Pose2d startPose = new Pose2d(-16.5,-62, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //actual auto


        waitForStart();

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                //Move Away From Wall
                .forward(0.5)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                //Park
                .strafeRight(47)
                .build();


        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
    }
}

