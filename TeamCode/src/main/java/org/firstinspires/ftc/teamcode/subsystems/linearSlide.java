package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class linearSlide {

    DcMotorEx linearSlide = null;

    public linearSlide(HardwareMap hardwareMap){
        this.linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide");

        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setVelocityPIDFCoefficients(
                linearSlideConstants.LINEARSLIDE_VEL_P,
                linearSlideConstants.LINEARSLIDE_VEL_I,
                linearSlideConstants.LINEARSLIDE_VEL_D,
                linearSlideConstants.LINEARSLIDE_VEL_FF);
        linearSlide.setPositionPIDFCoefficients(linearSlideConstants.LINEARSLIDE_POS_P);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setFourBarPosition(int position){
        linearSlide.setTargetPosition(position);
        linearSlide.setTargetPositionTolerance((int) linearSlideConstants.LINEARSLIDE_POS_TOLERENCE);
        linearSlide.setVelocity(linearSlideConstants.LINEARSLIDE_SET_VELOCITY);
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
