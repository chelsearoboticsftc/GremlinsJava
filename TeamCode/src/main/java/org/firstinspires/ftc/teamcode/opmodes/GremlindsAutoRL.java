/*package org.firstinspires.ftc.teamcode.opmodes;

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
public class GremlindsAutoRL extends LinearOpMode {
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
    double targetArmPosition;

    ElapsedTime waitTimer = new ElapsedTime();
    //double armDeployTime = 1;
    double clawOpenTime = 1;


    @Override
    public void runOpMode() {


        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);
        deliverySUbsystem deliverySUbsystem = new deliverySUbsystem(hardwareMap);

        Pose2d startPose = new Pose2d(-39.5, -62, Math.toRadians(90));

        drivetrain.setPoseEstimate(startPose);


        //specimen auton

        TrajectorySequence traj1 = drivetrain.trajectorySequenceBuilder(startPose)
                .strafeRight(32)
                .forward(27)
                .build(); //line up on x to submersible

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .forward(27)
                .build(); //come froeward from wall


        TrajectorySequence traj5 = drivetrain.trajectorySequenceBuilder(traj1.end())
                .back(27)
                .strafeRight(68.5)
                .build();
        //back up from submersible

       Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
                .strafeRight(68.5)
                .build(); //park


        waitForStart();
        drivetrain.followTrajectorySequenceAsync(traj1);
        targetLiftPosition = deliveryConstants.HIGH_SPECIMEN_BAR;
        currentState = State.MOVE_TO_SUB;

        while ((opModeIsActive()) && (!isStopRequested())) {
            switch (currentState) {
                case MOVE_TO_SUB:
                    if((!drivetrain.isBusy())&&
                       (!deliverySUbsystem.isLinearSlideBusy())) {
                        targetArmPosition = deliveryConstants.ARM_HB_POSITION;
                        waitTimer.reset();
                        currentState = State.MOVE_ARM_OUT;
                    }
                    break;
                case MOVE_ARM_OUT:
                    if((waitTimer.seconds() >= armDeployTime)){
                        targetLiftPosition = deliveryConstants.PUSH_DOWN_ON_SPECIMEN_HB;
                        currentState = State.DELIVER_SAMPLE;
                    }
                    break;
                case DELIVER_SAMPLE:
                    if(!deliverySUbsystem.isLinearSlideBusy()){
                        targetClawPosition = deliveryConstants.CLAW_EAT_OPEN;
                        waitTimer.reset();
                        currentState = State.RELEASE_SPECIEN;
                    }
                    break;
                case RELEASE_SPECIEN:
                    if(waitTimer.seconds() >= clawOpenTime){
                        drivetrain.followTrajectorySequenceAsync(traj5);
                        currentState = State.MOVE_TO_PARK;
                    }
                    break;
                case MOVE_TO_PARK:
                    if(!drivetrain.isBusy()){
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



        /*Trajectory traj1 = drivetrain.trajectoryBuilder(startPose)
                //Push Sample
                .strafeLeft(22)
                .build();

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .strafeRight(12)
                .build();

        Trajectory traj3 = drivetrain.trajectoryBuilder(traj2.end())
                //Move Away From Wall
                .forward(12)
                .build();

        Trajectory traj4 = drivetrain.trajectoryBuilder(traj3.end())
                //Park
                .strafeRight(112)
                .build();

        Trajectory traj5 = drivetrain.trajectoryBuilder(traj4.end())
                .back(35)
                .build();

        drivetrain.followTrajectory(traj1);
        drivetrain.followTrajectory(traj2);
        drivetrain.followTrajectory(traj3);
        drivetrain.followTrajectory(traj4);
        drivetrain.followTrajectory(traj5);



        //specimen auton

        /*Trajectory traj1 = drivetrain.trajectoryBuilder(startPose())
                .strafeRight(32)
                .build(); //line up on x to submersible

        Trajectory traj2 = drivetrain.trajectoryBuilder(traj1.end())
                .forward(27)
                .build(); //come froeward from wall

        Trajectory traj3 = driveTrain.trajectoryBuilder(traj2.end());
        while (opModeIsActive()) {
            linearSlide.setLSPosition(deliveryConstants.HIGH_SPECIMEN_BAR);
            linearSlide.isLSBusy();
            if (!linearSlide.isLSBusy()) {
                break;
            }

            Trajectory traj4 = driveTrain.trajectoryBuilder(traj3.end());
            while (opModeIsActive()) {
                linearSlide.setLSPosition(deliveryConstants.PUSH_DOWN_ON_SPECIMEN_HB);
                linearSlide.isLSBusy();
                if (!linearSlide.isLSBusy()) {
                    break;

                }

                Trajectory traj5 = driveTrain.trajectoryBuilder(traj4.end());
                while (opModeIsActive()) {
                    linearSlide.setLSPosition(deliveryConstants.PUSH_DOWN_ON_SPECIMEN_HB);
                    linearSlide.isLSBusy();
                    if (!linearSlide.isLSBusy()) {
                        break;


                        Trajectory traj6 = drivetrain.trajectoryBuilder(traj5.end())
                                .back(27)
                                .build();
                        //back up from submersible

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

                        //hello! we are gremlins!


                    }

                }

            }
        }}}*/