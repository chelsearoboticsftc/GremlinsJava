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


        /*
        specimen auton

        Trajectory traj1 = drivetrain.trajectoryBuilder(startPose())
            .strafeLeft(12)
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
            .strafeRight(63)
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

