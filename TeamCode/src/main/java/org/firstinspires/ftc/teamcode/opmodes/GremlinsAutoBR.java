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


        waitForStart();

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                //Move Away From Wall
                .strafeRight(26)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                //Park
                .strafeLeft(25)
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                //Park
                .forward(49)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(traj3.end())
                //Park
                .strafeRight(10)
                .build();

        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                //Park
                .back(39)
                .build();

        Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
                //Park
                .forward(40)
                .build();

        Trajectory traj7 = drivetrain.trajectoryBuilder(traj6.end())
                //Park
                .strafeRight(7)
                .build();

        Trajectory traj8 = drivetrain.trajectoryBuilder(traj7.end())
                //Park
                .back(39)
                .build();

        Trajectory traj9 = drivetrain.trajectoryBuilder(traj8.end())
                //Park
                .forward(40)
                .build();

        Trajectory traj10 = drivetrain.trajectoryBuilder(traj9.end())
                //Park
                .strafeLeft(3.5)
                .build();

        Trajectory traj11 = drivetrain.trajectoryBuilder(traj10.end())
                //Park
                .back(39)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
        drivetrain.followTrajectory(traj5);
        drivetrain.followTrajectory(traj6);
        drivetrain.followTrajectory(traj7);
        drivetrain.followTrajectory(traj8);
        drivetrain.followTrajectory(traj9);
        drivetrain.followTrajectory(traj10);
        drivetrain.followTrajectory(traj11);








    }
}

