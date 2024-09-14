package org.firstinspires.ftc.teamcode.subsystems.mainArm;

import com.acmerobotics.dashboard.config.Config;

@Config
public interface MainArmConfiguration {
    String MOTOR = "armMotor";
    double MOTOR_POWER = 1;
    double MOTOR_ADJUSTMENT_POWER = 0.2;

    // dalis copy-paste is goBILDA

    /* This constant is the number of encoder ticks for each degree of rotation of the arm.
    To find this, we first need to consider the total gear reduction powering our arm.
    First, we have an external 20t:100t (5:1) reduction created by two spur gears.
    But we also have an internal gear reduction in our motor.
    The motor we use for this arm is a 117RPM Yellow Jacket. Which has an internal gear
    reduction of ~50.9:1. (more precisely it is 250047/4913:1)
    We can multiply these two ratios together to get our final reduction of ~254.47:1.
    The motor's encoder counts 28 times per rotation. So in total you should see about 7125.16
    counts per rotation of the arm. We divide that by 360 to get the counts per degree. */
    double ARM_TICKS_PER_DEGREE = 19.7924893140647; //exact fraction is (194481/9826)

    /*Make super sure that the arm is reset into the robot, and the wrist is folded in before
     * you run start the OpMode. The motor's encoder is "relative" and will move the number of degrees
     * you request it to based on the starting position. So if it starts too high, all the motor
     * setpoints will be wrong. 💓💓
     */

    /* A number in degrees that the triggers can adjust the arm position by */
    double FUDGE_FACTOR = 15 * ARM_TICKS_PER_DEGREE;
    double POSITION_TOLERANCE = 15;

    double ARM_COLLAPSED_INTO_ROBOT  = 0;
    double ARM_COLLECT               = 250 * ARM_TICKS_PER_DEGREE;
    double ARM_CLEAR_BARRIER         = 230 * ARM_TICKS_PER_DEGREE;
    double ARM_SCORE                 = 160 * ARM_TICKS_PER_DEGREE;
    double ARM_ATTACH_HANGING_HOOK   = 120 * ARM_TICKS_PER_DEGREE;
    double ARM_LIFT_ROBOT            = 15  * ARM_TICKS_PER_DEGREE;
}
