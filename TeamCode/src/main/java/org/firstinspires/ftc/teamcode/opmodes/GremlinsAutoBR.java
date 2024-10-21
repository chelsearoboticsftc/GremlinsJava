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

        Pose2d startPose = new Pose2d(10, -8, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //actual auto

        //move away from wall
        Trajectory traj1 = drivetrain.trajectoryBuilder(new Pose2d())
                .forward(0.5)
                .build();

        //park
        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeRight(47)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);






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