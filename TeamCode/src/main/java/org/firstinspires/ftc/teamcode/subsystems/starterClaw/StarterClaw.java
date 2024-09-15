package org.firstinspires.ftc.teamcode.subsystems.starterClaw;

import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

public class StarterClaw extends VLRSubsystem<StarterClaw> implements StarterClawConfiguration{
    SimpleServo specimenServo;
    CRServo intakeServo;
    boolean isTurned = false;
    @Override
    protected void initialize(HardwareMap hardwareMap) {
        specimenServo = new SimpleServo(hardwareMap, SPECIMEN_SERVO, MIN_SPECIMEN_SERVO_DEGREE, MAX_SPECIMEN_SERVO_DEGREE);
        intakeServo = hardwareMap.get(CRServo.class, INTAKE_CRSERVO);
        specimenServo.turnToAngle(DEFAULT_SPECIMEN_SERVO_POSITION);
        intakeServo.setPower(INTAKE_OFF);

    }

    public void turn() {
        specimenServo.turnToAngle(SPECIMEN_SERVO_GRAB_POSITION);
    }

    public void revert() {
        specimenServo.turnToAngle(DEFAULT_SPECIMEN_SERVO_POSITION);
    }

//    public Boolean isTurned() {
//        return specimenServo.getAngle() == MAX_SPECIMEN_SERVO_DEGREE;
//    }

    public void toggleSpecimen() {
        if(isTurned) {
            revert();
            isTurned = false;
        } else{
            isTurned = true;
            turn();
        }

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

    public void toggleIntakeLoad() {
        if (intakeServo.getPower() == INTAKE_LOAD) {
            this.stop();
        } else {
            this.load();
        }
    }
}
