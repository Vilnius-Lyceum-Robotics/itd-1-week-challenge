package org.firstinspires.ftc.teamcode.subsystems.starterClaw.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.starterClaw.StarterClaw;

public class StarterClawLoadCommand extends CommandBase {
    private final StarterClaw starterClaw;
    private final long startTime;

    public StarterClawLoadCommand() {
        starterClaw = VLRSubsystem.getInstance(StarterClaw.class);
        this.startTime = System.currentTimeMillis();
    }

    public void initialize() {
        starterClaw.load();
    }


    public boolean isFinished() {
        if (System.currentTimeMillis() - this.startTime >= 1000) {
            starterClaw.stop();
            return true;
        }
        return false;
    }



}
