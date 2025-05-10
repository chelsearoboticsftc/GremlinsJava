package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class deliverySUbsystem {

    DcMotorEx linearSlide = null;
    public DcMotorEx arm = null;
    Servo claw = null;

    public deliverySUbsystem(HardwareMap hardwareMap){
        this.linearSlide = hardwareMap.get(DcMotorEx.class, "LS");
        this.arm = hardwareMap.get(DcMotorEx.class, "arm");
        this.claw = hardwareMap.get(Servo.class, "clawEat");

        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setVelocityPIDFCoefficients(
                deliveryConstants.LINEARSLIDE_VEL_P,
                deliveryConstants.LINEARSLIDE_VEL_I,
                deliveryConstants.LINEARSLIDE_VEL_D,
                deliveryConstants.LINEARSLIDE_VEL_FF);
        linearSlide.setPositionPIDFCoefficients(deliveryConstants.LINEARSLIDE_POS_P);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setVelocityPIDFCoefficients(
                deliveryConstants.LINEARSLIDE_VEL_P,
                deliveryConstants.LINEARSLIDE_VEL_I,
                deliveryConstants.LINEARSLIDE_VEL_D,
                deliveryConstants.LINEARSLIDE_VEL_FF);
        arm.setPositionPIDFCoefficients(deliveryConstants.LINEARSLIDE_POS_P);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setLinearSlidePosition(int position){
        linearSlide.setTargetPosition(position);
        linearSlide.setTargetPositionTolerance((int) deliveryConstants.LINEARSLIDE_POS_TOLERENCE);
        linearSlide.setVelocity(deliveryConstants.LINEARSLIDE_SET_VELOCITY);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setArmPosition(int position){
        arm.setTargetPosition(position);
        arm.setTargetPositionTolerance((int) deliveryConstants.LINEARSLIDE_POS_TOLERENCE);
        arm.setVelocity(deliveryConstants.LINEARSLIDE_SET_VELOCITY);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setClawPosition(double position){
        claw.setPosition(position);
    }


    public int getLinearSlidePosition(){
        return linearSlide.getCurrentPosition();
    }

    public int getArmPosition(){
        return  arm.getCurrentPosition();
    }

    public double getLinearSlideVelocity(){
        return linearSlide.getVelocity();
    }

    public double getArmVelocity(){return arm.getVelocity();}

    public void setLinearSlidePower(double power){

        linearSlide.setPower(power);
        linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setArmPower(double power){
        arm.setPower(power);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public boolean isLinearSlideBusy(){
        return linearSlide.isBusy();
    }

    public boolean isArmBusy(){
        return arm.isBusy();
    }
}
