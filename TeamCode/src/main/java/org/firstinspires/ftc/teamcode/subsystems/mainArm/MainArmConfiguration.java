package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.acmerobotics.dashboard.config.Config;

@Config
public interface MainArmConfiguration {
    String MOTOR = "armMotor";
    double MOTOR_POWER = 1;
    double MOTOR_ADJUSTMENT_POWER = 0.2;

    /* A number in degrees that the triggers can adjust the arm position by */

    double POSITION_TOLERANCE = 15;

    int ARM_COLLAPSED_INTO_ROBOT  = 0;
    int ARM_COLLECT               = -3000;
    int ARM_CLEAR_BARRIER         = -2686;
//    int ARM_SCORE                 = -160 * ARM_TICKS_PER_DEGREE;
    int ARM_SCORE = -1700;
    int ARM_ATTACH_HANGING_HOOK   = -970;
    int ARM_LIFT_ROBOT            = -121;
}
