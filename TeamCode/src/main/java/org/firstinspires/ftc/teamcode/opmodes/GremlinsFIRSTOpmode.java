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
            double drive = gamepad2.left_stick_y * -1;
            double strafe = gamepad2.left_stick_x * -1;
            double turn = gamepad2.right_stick_x * -1;


            // Spinny Go Wee Wee Out
            if (gamepad1.b) {
                SGWW.setDirection(DcMotor.Direction.REVERSE);
                SGWW.setPower(0.25);
            } else {
                SGWW.setPower(0);
            }

            //Spinny Go Wee Wee In
            if (gamepad1.x) {
                SGWW.setDirection(DcMotor.Direction.FORWARD);
                SGWW.setPower(0.25);
            } else {
                SGWW.setPower(0);
            }

            //Linear Slide Up
            if (gamepad1.dpad_up) {
                LS.setDirection(DcMotor.Direction.FORWARD);
                LS.setPower(0.10);
            } else {
                LS.setPower(0);
            }

            //Linear slide down
            if (gamepad1.dpad_down) {
                LS.setDirection(DcMotor.Direction.REVERSE);
                LS.setPower(0.10);
            } else {
                LS.setPower(0);
            }

            //Four Bar Up
            if (gamepad1.y) {
                fourBar.setDirection(DcMotor.Direction.FORWARD);
                fourBar.setPower(0.25);
            } else {
                fourBar.setPower(0);
            }

            //Four Bar Down
            if (gamepad1.a) {
                fourBar.setDirection(DcMotor.Direction.REVERSE);
                fourBar.setPower(0.25);
            } else {
                fourBar.setPower(0);
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
            frontRight.setPower(speeds[0]);
            frontLeft.setPower(speeds[1]);
            backRight.setPower(speeds[2]);
            backLeft.setPower(speeds[3]);

            telemetry.addData("FRspeed", speeds[0]);
            telemetry.addData("FLspeed", speeds[1]);
            telemetry.addData("BRspeed", speeds[2]);
            telemetry.addData("BLspeed", speeds[3]);



            telemetry.update();
        }
    }
}
