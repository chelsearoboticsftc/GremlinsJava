package org.firstinspires.ftc.teamcode.opmodes;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import org.firstinspires.ftc.teamcode.subsystems.FourBar;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;


@Autonomous
public class GremlinsAutoRRSpecimn extends LinearOpMode {

    @Override
    public void runOpMode() {

        FourBar fourBar = new FourBar(hardwareMap);
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Pose2d startPose = new Pose2d(-16.5, 62, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //actual auto


        waitForStart();

       /* Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                //Move to bar
                .forward(22)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                //line up on x axis
                .strafeLeft(9)
                .build();*/

       /* Trajectory traj3 = drivetrain.trajectoryBuilder(traj1.end())
                //Back up against wall
                .back(22)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(traj1.end())
                //line up on x axis
                .strafeRight(57)
                .build();

        drivetrain.followTrajectory(traj1);

         drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
        */

        TrajectorySequence SequenceOne = drivetrain.trajectorySequenceBuilder(startPose)
                .forward(22)
                .strafeLeft(9)
                .build();


        //4Bar
        TrajectorySequence SequenceTwo = drivetrain.trajectorySequenceBuilder(startPose)
                .back(22)
                .strafeRight(57)
                .build();

        drivetrain.followTrajectorySequence(SequenceOne);

        while(opModeIsActive()){
            fourBar.setFourBarPosition(250);
            fourBar.isFourBarBusy();
            if(!fourBar.isFourBarBusy()){
                break;
            }

            drivetrain.followTrajectorySequence(SequenceOne);

        }

    }
}

