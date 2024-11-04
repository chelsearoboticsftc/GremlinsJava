package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class GremlindsAutoRL extends LinearOpMode {

    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);



        Pose2d startPose = new Pose2d(-39.5,-62,Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);

        //push sample
        Trajectory RLAuto = drivetrain.trajectoryBuilder(new Pose2d())

                //Push Sample
                .strafeLeft(22)

                //Move Away From Sample
                .strafeRight(2)

                //Move Away From Wall
                .forward(23)

                //Park
                .strafeRight(104)
                .back(17)
                .build();


        waitForStart();
        drivetrain.followTrajectory(RLAuto);

}

    }


