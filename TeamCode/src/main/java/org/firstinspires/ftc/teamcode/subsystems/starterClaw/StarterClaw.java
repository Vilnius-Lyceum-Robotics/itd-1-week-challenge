package org.firstinspires.ftc.teamcode.subsystems.starterClaw;

import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

public class StarterClaw extends VLRSubsystem<StarterClaw> implements StarterClawConfiguration{
    SimpleServo specimenServo;
    CRServo intakeServo;
    @Override
    protected void initialize(HardwareMap hardwareMap) {
        specimenServo = new SimpleServo(hardwareMap, SERVO, MIN_SERVO_DEGREE, MAX_SERVO_DEGREE);
        intakeServo = hardwareMap.get(CRServo.class, CRSERVO);
        specimenServo.turnToAngle(DEFAULT_SERVO_POSITION);
        intakeServo.setPower(INTAKE_OFF);

    }

    public void turn() {
        specimenServo.turnToAngle(MAX_SERVO_DEGREE);
    }

    public void revert() {
        specimenServo.turnToAngle(DEFAULT_SERVO_POSITION);
    }

    public Boolean isTurned() {
        return specimenServo.getAngle() == MAX_SERVO_DEGREE;
    }

    public void toggle() {
        if(this.isTurned()) {
            revert();
        } else
            turn();


    }

    public void release() {
        intakeServo.setPower(INTAKE_RELEASE);
    }

    public void load() {
        intakeServo.setPower(INTAKE_LOAD);
    }

    public void stop() {
        intakeServo.setPower(INTAKE_OFF);

    }
}
