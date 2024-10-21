package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.lift.Lift;

@Config
public class MainArm extends VLRSubsystem<MainArm> implements MainArmConfiguration {
    DcMotor armMotor;

    int[] stdArmPositions = {
            ARM_COLLECT,
            ARM_CLEAR_BARRIER,
            ARM_PRESCORE,
            ARM_SCORE
    };
    int stdArmCurrPos = -1;
    boolean stdArmDirectionReversed = true;
    int[] liftArmPositions = {
            ARM_PREATTACH_HOOK,
            ARM_ATTACH_HOOK,
            ARM_LIFT_ROBOT
    };
    int liftArmCurrPos = -1;

    Lift lift;

    @Override
    protected void initialize(HardwareMap hardwareMap) {
        armMotor = hardwareMap.get(DcMotor.class, MOTOR);
        armMotor.setTargetPosition(ARM_COLLAPSED_INTO_ROBOT);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lift = VLRSubsystem.getInstance(Lift.class);
    }

    public void moveToDeg(double motorTargetDegrees) {
        System.out.println("arm moving to " + motorTargetDegrees);
        armMotor.setTargetPosition((int) motorTargetDegrees);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(MOTOR_POWER);
    }

    public void stdCyclePosition() {
        System.out.println("Current " + stdArmCurrPos);
        if (stdArmCurrPos == -1) {
            stdArmCurrPos = 1;
        } else {
            if (stdArmDirectionReversed) {
                stdArmCurrPos--;
            } else {
                stdArmCurrPos++;
            }
        }
        System.out.println("New " + stdArmCurrPos);

        if (stdArmCurrPos < 0) {
            stdArmCurrPos = 0;
            stdArmDirectionReversed = !stdArmDirectionReversed;
        } else if (stdArmCurrPos >= stdArmPositions.length) {
            stdArmCurrPos = stdArmPositions.length - 1;
            stdArmDirectionReversed = !stdArmDirectionReversed;
        }

        switch (stdArmCurrPos) {
            case 0:
//                lift.intake();
//                break;
            case 1:
            case 2:
                lift.retract();
                break;
            case 3:
                lift.scoring();
                break;
        }
        moveToDeg(stdArmPositions[stdArmCurrPos]);
    }

    public void liftCyclePosition() {
        liftArmCurrPos++;
        if (liftArmCurrPos >= liftArmPositions.length) {
            liftArmCurrPos = 0;
        }
        lift.retract();
        moveToDeg(liftArmPositions[liftArmCurrPos]);
    }

    public int getEncoderValue() {
        return armMotor.getCurrentPosition();
    }

    public void changeDir() {
        stdArmDirectionReversed = !stdArmDirectionReversed;
    }
}