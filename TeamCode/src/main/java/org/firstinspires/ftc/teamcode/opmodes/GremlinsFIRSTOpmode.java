package org.firstinspires.ftc.teamcode.opmodes;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.driveConstants;
import org.firstinspires.ftc.teamcode.subsystems.linearSlideConstants;


@TeleOp
public class GremlinsFIRSTOpmode extends LinearOpMode {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotor SGWW = null;
    private DcMotor fourBar = null;
    private DcMotor LS = null;



    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "initulized");
        telemetry.update();


        //Here we are linking the motor objects tot he hardware map/robot config
        frontLeft   = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        SGWW = hardwareMap.get(DcMotor.class, "SGWW");
        fourBar = hardwareMap.get(DcMotor.class, "fourBar");
        LS = hardwareMap.get(DcMotor.class, "LS");


        //Here we are setting the motor directions for positive power
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        SGWW.setDirection(DcMotor.Direction.REVERSE);
        fourBar.setDirection(DcMotor.Direction.FORWARD);



        waitForStart();


        while(opModeIsActive()){
            telemetry.addData("Status", "Running");


            //Read Gamepad Drive Input
            double drive = gamepad2.left_stick_y * driveConstants.GAMEPAD_MULITPIER;
            double strafe = gamepad2.left_stick_x * driveConstants.GAMEPAD_MULITPIER;
            double turn = gamepad2.right_stick_x * driveConstants.GAMEPAD_MULITPIER;


            //Linear Slide Up
            if (gamepad1.dpad_up) {
                LS.setDirection(DcMotor.Direction.FORWARD);
                LS.setPower(linearSlideConstants.LINEARSIDE_GO_POWER);
            } else {
                LS.setPower(linearSlideConstants.LINEARSLIDE_STOP_POWER);
            }

            //Linear slide down
            if (gamepad1.dpad_down) {
                LS.setDirection(DcMotor.Direction.REVERSE);
                LS.setPower(linearSlideConstants.LINEARSIDE_GO_POWER);
            } else {
                LS.setPower(linearSlideConstants.LINEARSLIDE_STOP_POWER);
            }

            double[] speeds = {
                    (drive+strafe+turn),//frontLeft -> 0
                    (drive-strafe-turn),//frontRight -> 1
                    (drive-strafe+turn),//rearLeft -> 2
                    (drive+strafe-turn)//rearRight -> 3
            };


            //Loop through speeds array and find the maximum magnitude of all 4 speeds
            double max = 0;
            for(int i = 0; i < speeds.length;i++){
                if (speeds[i] > Math.abs(max)){
                    max = Math.abs(speeds[i]);
                }
            }


            // if and only if max is greater than one then normalize to the range of [-1,1]
            if (max > 1){
                for(int i = 0; i < speeds.length;i++){
                    speeds[i] /= max;// speeds[i] = speeds[i]/max;
                }
            }
            frontRight.setPower(speeds[(int) driveConstants.FR_SPEED]);
            frontLeft.setPower(speeds[(int) driveConstants.Fl_SPEED]);
            backRight.setPower(speeds[(int) driveConstants.BR_SPEED]);
            backLeft.setPower(speeds[(int) driveConstants.BL_SPEED]);

            telemetry.addData("FRspeed", speeds[(int) driveConstants.FR_SPEED]);
            telemetry.addData("FLspeed", speeds[(int) driveConstants.Fl_SPEED]);
            telemetry.addData("BRspeed", speeds[(int) driveConstants.BR_SPEED]);
            telemetry.addData("BLspeed", speeds[(int) driveConstants.BL_SPEED]);



            telemetry.update();
        }
    }
}
