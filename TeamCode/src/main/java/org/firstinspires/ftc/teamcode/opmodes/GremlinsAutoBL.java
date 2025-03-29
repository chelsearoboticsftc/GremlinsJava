package org.firstinspires.ftc.teamcode.opmodes;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class GremlinsAutoBL extends LinearOpMode {
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
                .strafeRight(22)
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                //Move Away From Wall
                .forward(50)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(traj3.end())
                //Park
                .strafeLeft(14)
                .build();

        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                .back(35)
                .build();

        Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
                .strafeRight(22)
                .build();

        Trajectory traj7 = drivetrain.trajectoryBuilder(traj6.end())
                .back(8)
                .build();

        Trajectory traj8 = drivetrain.trajectoryBuilder(traj7.end())
                .strafeLeft(28)
                .build();

        Trajectory traj9 = drivetrain.trajectoryBuilder(traj8.end())
                .strafeRight(18)
                .build();

        Trajectory traj10 = drivetrain.trajectoryBuilder(traj9.end())
                .forward(50)
                .build();

        Trajectory traj11 = drivetrain.trajectoryBuilder(traj10.end())
                .back(35)
                .build();

        Trajectory traj12 = drivetrain.trajectoryBuilder(traj11.end())
                .strafeLeft(17)
                .build();

        Trajectory traj13 = drivetrain.trajectoryBuilder(traj12.end())
                .back(47.5)
                .build();

        Trajectory traj14 = drivetrain.trajectoryBuilder(traj13.end())
                .forward(47.5)
                .build();

        Trajectory traj15 = drivetrain.trajectoryBuilder(traj14.end())
                .forward(47.5)
                .build();

        Trajectory traj16 = drivetrain.trajectoryBuilder(traj15.end())
                .strafeLeft(6.5)
                .build();

        Trajectory traj17 = drivetrain.trajectoryBuilder(traj16.end())
                .back(33)
                .build();

        Trajectory traj18 = drivetrain.trajectoryBuilder(traj17.end())
                .strafeRight(123)
                .build();

        Trajectory traj19 = drivetrain.trajectoryBuilder(traj18.end())
                .back(16.5)
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
        drivetrain.followTrajectory(traj12);
        drivetrain.followTrajectory(traj13);
        drivetrain.followTrajectory(traj14);
        drivetrain.followTrajectory(traj15);
        drivetrain.followTrajectory(traj16);
        drivetrain.followTrajectory(traj17);
        drivetrain.followTrajectory(traj18);
        drivetrain.followTrajectory(traj19);


        /*
        specimen auton

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose())
            .strafeRight(32)
            .build(); //line up on x to submersible

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
            .forward(27)
            .build(); //come froeward from wall

        Trajectory traj3 = delivery/whatever other thing we name the subsystem.trajectoryBuilder(traj2.end())
            .(enter subsystem command that we create) //places specimen onto bar
            .build();

        Trajectory traj4 = delivery.trajectoryBuilder(traj3.end())
            .(push down on specimen)
            .build();

         Trajectory traj5 = delivery.trajectoryBuilder(traj4.end())
            .(pull back arm)
            .build()

         Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
            .back(27)
            .build() //back up from submersible

         Trajectory traj7 = drivetrain.trajectoryBuilder(traj6.end())
            .strafeRight(68.5)
            .build; //park

            drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
        drivetrain.followTrajectory(traj5);
        drivetrain.followTrajectory(traj6);
        drivetrain.followTrajectory(traj7);
         */



    }
}

