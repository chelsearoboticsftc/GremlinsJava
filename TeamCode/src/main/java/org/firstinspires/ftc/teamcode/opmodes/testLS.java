//package org.firstinspires.ftc.teamcode.opmodes;

//import org.firstinspires.ftc.teamcode.subsystems.LS;

/*@TeleOp
public class testFourBar extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
       double maxFourBarVelocity = 0;
        LS linearSlide = new LS(hardwareMap);
        waitForStart();
         while (opModeIsActive()){

            if(gamepad1.a){
                 linearSlide.setLSPower(0.80);
             } else if (gamepad1.x) {
                linearSlide.setLSPower(-0.80);
             } else {
                 linearSlide.setLSPower(0);
             }


             HeLlO wE aRe GrEmLiNs
            if(gamepad1.y){
                 linearSlide.setLSPosition(250);
             }
             else if(gamepad1.a){
                 linearSlide.setLSPosition(0);
             }
             if(Math.abs(fourBar.getFourBarVelocity())>maxFourBarVelocity){
                 maxFourBarVelocity = (Math.abs(fourBar.getFourBarVelocity()));
             }

             telemetry.addData("FourBarPosition", fourBar.getFourBarPosition());
             telemetry.addData("maxFourBarVelocity", maxFourBarVelocity);
             telemetry.update();
         }
    }
}

//REVISION FOR LINEAR SLIDE


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.deliverySUbsysytem;
import.org.firstinspires.ftc.teamcode.subsystems.deliveryConstants;


@TeleOp
public class testLinearSLideTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
       double maxFourBarVelocity = deliveryConstants.MAX_LINEAR_SLIDE_VELOCITY;
        LS linearSlide = new LS(hardwareMap);
        waitForStart();
         while (opModeIsActive()){

             if(gamepad1.a){
                 linearSLide.setLSPower(0.80);
             } else if (gamepad1.x) {
                linearSlide.setLSPower(-0.80);
             } else {
                 linearSlide.setLSPower(0);
             }
             if(gamepad1.y){
                 linearSlide.setLSPosition(250);
             }

                          else if(gamepad1.a){
                 linearSlide.setLSPosition(0);
             }
             if(Math.abs(linearSlide.getLSVelocity())>maxLinearSlideVelocity){
                 maxLinearSlideVelocity = (Math.abs(linearSlide.getLinearSlideVelocity()));
             }

             telemetry.addData("LinearSlidePosition", linearSlide.getLSPosition());
             telemetry.addData("maxLinearSlideVelocity", maxLSVelocity);
             telemetry.update();
         }
    }
}

 */


