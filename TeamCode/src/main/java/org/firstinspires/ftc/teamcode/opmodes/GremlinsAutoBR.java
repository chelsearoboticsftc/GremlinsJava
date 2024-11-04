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

        Pose2d startPose = new Pose2d(-16.5, 62, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //actual auto


        Trajectory traj1 = drivetrain.trajectoryBuilder(new Pose2d())

               //Move Away from Wall
                .forward(0.5)

                //Park
                .strafeRight(47)
                .build();

        drivetrain.followTrajectory(traj1);







    }
}

