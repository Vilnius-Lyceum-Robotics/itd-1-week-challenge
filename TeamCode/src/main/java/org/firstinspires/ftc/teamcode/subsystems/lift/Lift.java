package org.firstinspires.ftc.teamcode.subsystems.lift;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

public class Lift extends VLRSubsystem<Lift> implements LiftConfiguration {
    DcMotor lift;

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        lift = hardwareMap.get(DcMotor.class, MOTOR);

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // for testing disabled

        lift.setTargetPosition(0);
        lift.setPower(0);
    }

    public void setPosition(int position) {
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setTargetPosition(position);
        lift.setPower(1);
    }

    public void stop() {
        lift.setPower(0);
    }

    public void intake() {
        setPosition(LIFT_INTAKE_POS);
    }

    public void scoring() {
        setPosition(LIFT_SCORING_POS);
    }

    public void retract() {
        setPosition(LIFT_RETRACT_POS);
    }

    public int getEncoderValue() {
        return lift.getCurrentPosition();
    }
}
