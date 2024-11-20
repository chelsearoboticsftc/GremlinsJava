package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FourBar {


    DcMotorEx fourBar = null;

    public FourBar(HardwareMap hardwareMap){
        this.fourBar = hardwareMap.get(DcMotorEx.class, "fourBar");

        fourBar.setDirection(DcMotorSimple.Direction.FORWARD);
        fourBar.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fourBar.setVelocityPIDFCoefficients(
                FourBarConstants.FOURBAR_VEL_P,
                FourBarConstants.FOURBAR_VEL_I,
                FourBarConstants.FOURBAR_VEL_D,
                FourBarConstants.FOURBAR_VEL_FF);
        fourBar.setPositionPIDFCoefficients(FourBarConstants.FOURBAR_POS_P);
        fourBar.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setFourBarPosition(int position){
        fourBar.setTargetPosition(position);
        fourBar.setTargetPositionTolerance(5);
        fourBar.setVelocity(2240);
        fourBar.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public int getFourBarPosition(){
        return fourBar.getCurrentPosition();
    }

    public double getFourBarVelocity(){
        return fourBar.getVelocity();
    }

    public void setFourBarPower(double power){

        fourBar.setPower(power);
        fourBar.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public boolean isFourBarBusy(){
        return fourBar.isBusy();
    }
}
