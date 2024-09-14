package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.mainArm.commands.MoveToPositionCommand;

public class MainArm extends VLRSubsystem<MainArm> implements MainArmConfiguration{
    Motor armMotor;
    CommandScheduler cs;

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        armMotor = new Motor(hardwareMap, MOTOR);
        armMotor.setTargetPosition((int)ARM_COLLAPSED_INTO_ROBOT);
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setPositionTolerance(POSITION_TOLERANCE);
        armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        armMotor.resetEncoder();

        cs = CommandScheduler.getInstance();
    }

    public void moveScoring(){
        cs.schedule(new MoveToPositionCommand(ARM_SCORE));
    }

    public void moveClearBarrier(){

        cs.schedule(new MoveToPositionCommand(ARM_CLEAR_BARRIER));
    }

    public void moveCollectSample(){
        cs.schedule(new MoveToPositionCommand(ARM_COLLECT));
    }

    public void attachHook(){
        cs.schedule(new MoveToPositionCommand(ARM_ATTACH_HANGING_HOOK));
    }

    public void liftRobot(){
        cs.schedule(new MoveToPositionCommand(ARM_LIFT_ROBOT));
    }

    public void moveToDeg(double motorTargetDegrees){
        armMotor.setTargetPosition((int)motorTargetDegrees);
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.set(MOTOR_POWER);
    }

    public int getEncoderValue() {
        return armMotor.getCurrentPosition();
    }

    @Override
    public void periodic() {
        System.out.println("INVOKED");
        if (armMotor.atTargetPosition()) armMotor.set(0);
    }
}