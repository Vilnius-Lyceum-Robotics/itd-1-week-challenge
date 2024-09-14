package org.firstinspires.ftc.teamcode.subsystems.mainArm.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.mainArm.MainArm;

public class MoveToPositionCommand extends CommandBase {
    private MainArm mainArm;
    private int pos;
    public MoveToPositionCommand(int position){
        pos = position;
        this.mainArm = VLRSubsystem.getInstance(MainArm.class);
        addRequirements(mainArm);
    }

    public void initialize(){
        mainArm.moveToDeg(pos);
    }

    public boolean isFinished() {
        return true;
    }
}
