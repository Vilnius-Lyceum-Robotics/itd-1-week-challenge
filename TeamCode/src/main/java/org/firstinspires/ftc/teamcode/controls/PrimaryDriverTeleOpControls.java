package org.firstinspires.ftc.teamcode.controls;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.helpers.controls.DriverControls;
import org.firstinspires.ftc.teamcode.helpers.controls.button.ButtonCtl;
import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.claw.commands.ClawToggleCommand;
import org.firstinspires.ftc.teamcode.subsystems.example.ExampleClaw;
import org.firstinspires.ftc.teamcode.subsystems.lift.commands.LiftRunToPositionCommand;
import org.firstinspires.ftc.teamcode.subsystems.lift.commands.LiftToggleCommand;
import org.firstinspires.ftc.teamcode.subsystems.starterClaw.StarterClaw;
import org.firstinspires.ftc.teamcode.subsystems.starterClaw.commands.StarterClawLoadCommand;
import org.firstinspires.ftc.teamcode.subsystems.starterClaw.commands.StarterClawReleaseCommand;

/**
 * Abstraction for primary driver controls. All controls will be defined here.
 * For this to work well, all subsystems will be defined as singletons.
 */
public class PrimaryDriverTeleOpControls extends DriverControls {
    public PrimaryDriverTeleOpControls(Gamepad gamepad) {
        super(new GamepadEx(gamepad));

        CommandScheduler cs = CommandScheduler.getInstance();

        //ExampleClaw exampleClaw = VLRSubsystem.getInstance(ExampleClaw.class);
        StarterClaw starterClaw = VLRSubsystem.getInstance(StarterClaw.class);

        /*
        add(new ButtonCtl(GamepadKeys.Button.X, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean x) -> exampleClaw.open()))
        add(new ButtonCtl(GamepadKeys.Button.Y, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean y) -> exampleClaw.close()))
        */
        add(new ButtonCtl(GamepadKeys.Button.A, ButtonCtl.Trigger.WAS_JUST_PRESSED, true,(Boolean a) -> starterClaw.toggle()));
        add(new ButtonCtl(GamepadKeys.Button.Y, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean y) -> cs.schedule(new StarterClawReleaseCommand())));
        add(new ButtonCtl(GamepadKeys.Button.X, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean x) -> cs.schedule(new StarterClawLoadCommand())));

    }
}
