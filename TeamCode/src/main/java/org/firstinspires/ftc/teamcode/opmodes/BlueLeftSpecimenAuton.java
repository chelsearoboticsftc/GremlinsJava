package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.deliveryConstants;
import org.firstinspires.ftc.teamcode.subsystems.deliverySUbsystem;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class BlueLeftSpecimenAuton extends LinearOpMode {
    enum State {
        IDLE,
        MOVE_TO_SUB,
        MOVE_ARM_OUT,
        DELIVER_SAMPLE,
        RELEASE_SPECIEN,
        MOVE_TO_PARK
    }

    State currentState = State.IDLE;
    int targetLiftPosition;
    double targetClawPosition;
    int targetArmPosition;

    ElapsedTime waitTimer = new ElapsedTime();
    double clawOpenTime = 1;


    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);
        deliverySUbsystem deliverySUbsystem = new deliverySUbsystem(hardwareMap);

        Pose2d startPose = new Pose2d(39.5, 62, Math.toRadians(270));

        drivetrain.setPoseEstimate(startPose);


        //specimen auton

        TrajectorySequence traj1 = drivetrain.trajectorySequenceBuilder(startPose)
                .strafeRight(32)
                .forward(27)
                .build(); //line up on x to submersible

       /* Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .forward(27)
                .build(); //come froeward from wall*/


        TrajectorySequence traj5 = drivetrain.trajectorySequenceBuilder(traj1.end())
                .back(27)
                .strafeRight(68.5)
                .build();
        //back up from submersible

      /*  Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
                .strafeRight(68.5)
                .build(); //park*/


        waitForStart();
        drivetrain.followTrajectorySequenceAsync(traj1);
        targetLiftPosition = deliveryConstants.HIGH_SPECIMEN_BAR;
        currentState = State.MOVE_TO_SUB;

        while ((opModeIsActive()) && (!isStopRequested())) {
            switch (currentState) {
                case MOVE_TO_SUB:
                    if ((!drivetrain.isBusy()) &&
                            (!deliverySUbsystem.isLinearSlideBusy())) {
                        targetArmPosition = deliveryConstants.ARM_HB_POSITION;
                        waitTimer.reset();
                        currentState = State.MOVE_ARM_OUT;
                    }
                    break;
                case MOVE_ARM_OUT:
                    if (!deliverySUbsystem.arm.isBusy()) {
                        targetLiftPosition = deliveryConstants.PUSH_DOWN_ON_SPECIMEN_HB;
                        currentState = State.DELIVER_SAMPLE;
                    }
                    break;
                case DELIVER_SAMPLE:
                    if (!deliverySUbsystem.isLinearSlideBusy()) {
                        targetClawPosition = deliveryConstants.CLAW_EAT_OPEN;
                        waitTimer.reset();
                        currentState = State.RELEASE_SPECIEN;
                    }
                    break;
                case RELEASE_SPECIEN:
                    if (waitTimer.seconds() >= clawOpenTime) {
                        drivetrain.followTrajectorySequenceAsync(traj5);
                        currentState = State.MOVE_TO_PARK;
                    }
                    break;
                case MOVE_TO_PARK:
                    if (!drivetrain.isBusy()) {
                        currentState = State.IDLE;
                    }
                    break;
            }
        }
        drivetrain.update();
        deliverySUbsystem.setLinearSlidePosition(targetLiftPosition);
        deliverySUbsystem.setArmPosition(targetArmPosition);
        deliverySUbsystem.setClawPosition(targetClawPosition);
        telemetry.addData("StateMachineCurrent", currentState);
        telemetry.update();
    }
}