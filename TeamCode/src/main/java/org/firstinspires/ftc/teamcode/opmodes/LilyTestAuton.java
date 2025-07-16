package org.firstinspires.ftc.teamcode.opmodes;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.deliveryConstants;
import org.firstinspires.ftc.teamcode.subsystems.deliverySUbsystem;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class LilyTestAuton extends LinearOpMode{
enum State{

    IDLE,
    STRAFE_RIGHT,
    FOWARD,
    STRAFE_LEFT,
    BACK
}
State currentState = State.IDLE;

@Override
    public void runOpMode(){

}
}
