package org.firstinspires.ftc.teamcode.subsystems.starterClaw;

import com.acmerobotics.dashboard.config.Config;

@Config
public interface StarterClawConfiguration {
    String SPECIMEN_SERVO = "specimenServo";
    int MIN_SPECIMEN_SERVO_DEGREE = 0;
    int MAX_SPECIMEN_SERVO_DEGREE = 180;
    int DEFAULT_SPECIMEN_SERVO_POSITION = 90;

    String INTAKE_CRSERVO = "intakeServo";
    double INTAKE_OFF = 0.0;
    double INTAKE_LOAD = 1.0;
    double INTAKE_RELEASE = -1.0;
}
