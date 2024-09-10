package org.firstinspires.ftc.teamcode.subsystems.example;

import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

public class ExampleClaw extends VLRSubsystem<ExampleClaw> implements ExampleClawConfiguration {
    SimpleServo servo1;
    @Override
    protected void initialize(HardwareMap hardwareMap) {
        servo1 = new SimpleServo(hardwareMap, SERVO, MIN_SERVO_DEGREE, MAX_SERVO_DEGREE);
        servo1.turnToAngle(DEFAULT_SERVO_POSITION);
    }

    public void open() {
        // Open the claw
        servo1.turnToAngle(MAX_SERVO_DEGREE);
    }

    public void close() {
        // Close the claw
        servo1.turnToAngle(MIN_SERVO_DEGREE);
    }
}
