package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

@Config
public class MainArm extends VLRSubsystem<MainArm> implements MainArmConfiguration{
    DcMotor armMotor;
    @Override
    protected void initialize(HardwareMap hardwareMap) {
        armMotor = hardwareMap.get(DcMotor.class, MOTOR);
        armMotor.setTargetPosition(ARM_COLLAPSED_INTO_ROBOT);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void moveScoring(){
        moveToDeg(ARM_SCORE);
    }

    public void moveClearBarrier(){
        moveToDeg(ARM_CLEAR_BARRIER);
    }

    public void moveCollectSample(){
        moveToDeg(ARM_COLLECT);
    }

    public void attachHook(){
        moveToDeg(ARM_ATTACH_HANGING_HOOK);
    }

    public void liftRobot(){
        moveToDeg(ARM_LIFT_ROBOT);
    }

    public void moveToDeg(double motorTargetDegrees){
        System.out.println("ARM MOTOR MODE: " + armMotor.getMode());
        armMotor.setTargetPosition((int)motorTargetDegrees);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(MOTOR_POWER);
    }

    public int getEncoderValue() {
        return armMotor.getCurrentPosition();
    }
}