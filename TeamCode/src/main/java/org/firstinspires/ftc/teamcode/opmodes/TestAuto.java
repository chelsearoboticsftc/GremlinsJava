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

/*package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

@Autonomous
public class SmurfNeutSamplesBlue extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        Pose2d startingPose = new Pose2d(39.5,62,Math.toRadians(270));
        Vector2d wayPoint1 = new Vector2d(34,24);
        Pose2d parkPosition = new Pose2d(21,11,0);

        TrajectoryVelocityConstraint velocityConstraint;

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence smurfNeutralSamples = drivetrain.trajectorySequenceBuilder(startingPose)
                .forward(2)
                .strafeLeft(18)
                .strafeRight(4)
                .splineToConstantHeading(wayPoint1,Math.toRadians(270))
                .forward(12)
                //Neutral sample 1
                .strafeLeft(14)
                .back(40)
                .forward(40)
                //Neutral sample 2
                .strafeLeft(10)
                .back(42)
                .forward(42)
                //Neutral sample 3
                .strafeLeft(4.5)
                .back(40)
                .forward(2)
                //Clean up!
                .strafeRight(25)
                .back(10)
                .strafeLeft(15)
                //Park!
                .splineToLinearHeading(parkPosition,0)
                .build();

        waitForStart();

        drivetrain.followTrajectorySequence(smurfNeutralSamples);

    }
}




package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

@Autonomous
public class SmurfNeutSamplesRed extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        Pose2d startingPose = new Pose2d(-39.5,-62,Math.toRadians(90));
        Vector2d wayPoint1 = new Vector2d(-34,-24);
        Pose2d parkPosition = new Pose2d(-21,-11,0);

        TrajectoryVelocityConstraint velocityConstraint;

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence smurfNeutralSamples = drivetrain.trajectorySequenceBuilder(startingPose)
                .forward(2)
                .strafeLeft(18)
                .strafeRight(4)
                .splineToConstantHeading(wayPoint1,Math.toRadians(90))
                .forward(12)
                //Neutral sample 1
                .strafeLeft(14)
                .back(40)
                .forward(40)
                //Neutral sample 2
                .strafeLeft(10)
                .back(42)
                .forward(42)
                //Neutral sample 3
                .strafeLeft(4.5)
                .back(40)
                .forward(2)
                //Clean up!
                .strafeRight(25)
                .back(10)
                .strafeLeft(15)
                //Park!
                .splineToLinearHeading(parkPosition,0)
                .build();

        waitForStart();

        drivetrain.followTrajectorySequence(smurfNeutralSamples);

    }
}

*/