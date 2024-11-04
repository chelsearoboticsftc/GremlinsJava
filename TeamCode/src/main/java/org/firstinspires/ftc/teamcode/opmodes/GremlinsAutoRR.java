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


        Trajectory RRAuto = drivetrain.trajectoryBuilder(new Pose2d())


                //Move Away From Wall
                .forward(0.5)

                //Park
                .strafeLeft(47)
                .build();

        waitForStart();

        drivetrain.followTrajectory(RRAuto);
    }
}

