package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class deliverySUbsystem {

    DcMotorEx linearSlide = null;
    Servo arm = null;

    public deliverySUbsystem(HardwareMap hardwareMap){
        this.linearSlide = hardwareMap.get(DcMotorEx.class, "LS");
        this.arm = hardwareMap.get(Servo.class, "arm");

        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(Servo.Direction.FORWARD);
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setVelocityPIDFCoefficients(
                deliveryConstants.LINEARSLIDE_VEL_P,
                deliveryConstants.LINEARSLIDE_VEL_I,
                deliveryConstants.LINEARSLIDE_VEL_D,
                deliveryConstants.LINEARSLIDE_VEL_FF);
        linearSlide.setPositionPIDFCoefficients(deliveryConstants.LINEARSLIDE_POS_P);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setFourBarPosition(int position){
        linearSlide.setTargetPosition(position);
        linearSlide.setTargetPositionTolerance((int) deliveryConstants.LINEARSLIDE_POS_TOLERENCE);
        linearSlide.setVelocity(deliveryConstants.LINEARSLIDE_SET_VELOCITY);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public int getLinearSlidePosition(){
        return linearSlide.getCurrentPosition();
    }

    public double getLinearSlideVelocity(){
        return linearSlide.getVelocity();
    }

    public void setLinearSlidePower(double power){

        linearSlide.setPower(power);
        linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public boolean isLinearSlideBusy(){
        return linearSlide.isBusy();
    }
}
