package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

public class MainArm extends VLRSubsystem<MainArm> implements MainArmConfiguration{
    Motor armMotor;

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        armMotor = new Motor(hardwareMap, MOTOR, Motor.GoBILDA.RPM_117);
        armMotor.setTargetPosition(0);
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setPositionTolerance(15);
        armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        armMotor.stopMotor(); // ar reikalingas?
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
        moveToDeg(ARM_LIFT_ROBOT);
    }


    private void moveToDeg(double motorTargetDegrees){
        armMotor.setTargetPosition((int)motorTargetDegrees);
        while (!armMotor.atTargetPosition()) {
            armMotor.set(MOTOR_POWER);
        }
        armMotor.stopMotor();
    }
}
