package org.firstinspires.ftc.teamcode.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.driveConstants;
import org.firstinspires.ftc.teamcode.subsystems.deliveryConstants;


@TeleOp
public class GremlinsFIRSTOpmode extends LinearOpMode {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private Servo clawEat = null;
    private DcMotor LS = null;
    private Servo arm = null;



    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "initulized");
        telemetry.update();


        //Here we are linking the motor objects tot he hardware map/robot config
        frontLeft   = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        clawEat = hardwareMap.get(Servo.class, "clawEatAsServo");
        arm = hardwareMap.get(Servo.class, "arm");
        LS = hardwareMap.get(DcMotor.class, "LS");


        //Here we are setting the motor directions for positive power
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        clawEat.setDirection(Servo.Direction.FORWARD);
        arm.setDirection(Servo.Direction.FORWARD);



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
                LS.setPower(deliveryConstants.LINEARSIDE_GO_POWER);
            } else {
                LS.setPower(deliveryConstants.LINEARSLIDE_STOP_POWER);
            }

            //Linear slide down
            if (gamepad1.dpad_down) {
                LS.setDirection(DcMotor.Direction.REVERSE);
                LS.setPower(deliveryConstants.LINEARSIDE_GO_POWER);
            } else {
                LS.setPower(deliveryConstants.LINEARSLIDE_STOP_POWER);
            }

            // ClawThingyCode
            if (gamepad2.x) {
                // Claw open
                clawEat.setPosition(deliveryConstants.CLAW_EAT_OPEN);
            } else if (gamepad2.b) {
                // Claw close
                clawEat.setPosition(deliveryConstants.CLAW_EAT_CLOSE);
            }

            double[] speeds = {
                    (drive+strafe+turn),//frontLeft -> 0
                    (drive-strafe-turn),//frontRight -> 1
                    (drive-strafe+turn),//rearLeft -> 2
                    (drive+strafe-turn)//rearRight -> 3
            };


            //Loop through speeds array and find the maximum magnitude of all 4 speeds
            double max = driveConstants.MAX_THINGY;
            for(int i = (int) driveConstants.I_THINGY; i < speeds.length; i++){
                if (speeds[i] > Math.abs(max)){
                    max = Math.abs(speeds[i]);
                }
            }


            // if and only if max is greater than one then normalize to the range of [-1,1]
            if (max > driveConstants.ONE){
                for(int i = (int) driveConstants.I_THINGY; i < speeds.length; i++){
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
