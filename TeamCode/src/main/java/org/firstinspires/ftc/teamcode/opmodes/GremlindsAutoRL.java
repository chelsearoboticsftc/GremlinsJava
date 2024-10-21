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

        waitForStart();

        //push sample
        Trajectory traj1 = drivetrain.trajectoryBuilder(new Pose2d())
                .strafeLeft(22)
                .build();


        //move away from sample
        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeRight(2)
                .build();
        drivetrain.followTrajectory(traj2);

        //park
        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                .forward(23)
                .build();


        Trajectory traj4 = drivetrain.trajectoryBuilder(traj3.end())
                .strafeRight(104)
                .build();


        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                .back(17)
                .build();



        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
        drivetrain.followTrajectory(traj5);
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