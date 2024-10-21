package org.firstinspires.ftc.teamcode.controls;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.auto.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.helpers.controls.DriverControls;
import org.firstinspires.ftc.teamcode.helpers.controls.button.ButtonCtl;
import org.firstinspires.ftc.teamcode.helpers.controls.trigger.TriggerCtl;
import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.starterClaw.StarterClaw;
import org.firstinspires.ftc.teamcode.subsystems.mainArm.MainArm;
import org.firstinspires.ftc.teamcode.subsystems.chassis.Chassis;

import org.firstinspires.ftc.teamcode.subsystems.starterClaw.commands.StarterClawReleaseCommand;


/**
 * Abstraction for primary driver controls. All controls will be defined here.
 * For this to work well, all subsystems will be defined as singletons.
 */
public class PrimaryDriverTeleOpControls extends DriverControls {
    public PrimaryDriverTeleOpControls(Gamepad gamepad) {
        super(new GamepadEx(gamepad));

        CommandScheduler cs = CommandScheduler.getInstance();

        StarterClaw starterClaw = VLRSubsystem.getInstance(StarterClaw.class);
        MainArm mainArm = VLRSubsystem.getInstance(MainArm.class);
        Chassis chassis = VLRSubsystem.getInstance(Chassis.class);

//        add(new ButtonCtl(GamepadKeys.Button.A, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean a) -> starterClaw.toggleSpecimen()));
//        add(new ButtonCtl(GamepadKeys.Button.Y, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean y) -> cs.schedule(new StarterClawReleaseCommand())));
//        add(new ButtonCtl(GamepadKeys.Button.X, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean x) -> starterClaw.toggleIntakeLoad()));
//        add(new ButtonCtl(GamepadKeys.Button.B, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean b) -> mainArm.changeDir()));
//
//        add(new ButtonCtl(GamepadKeys.Button.LEFT_BUMPER, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean rb) -> mainArm.stdCyclePosition()));
//        add(new ButtonCtl(GamepadKeys.Button.RIGHT_BUMPER, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean lb) -> mainArm.liftCyclePosition()));
        addBothSticksHandler(
                (Double leftY, Double leftX, Double rightY, Double rightX) -> {
                    chassis.drive(leftY, -leftX, -rightX);
                }
        );
        // add(new TriggerCtl(GamepadKeys.Trigger.LEFT_TRIGGER, (Double lt) -> mainArm.finePositionAdjustment(lt)));

    }
}
