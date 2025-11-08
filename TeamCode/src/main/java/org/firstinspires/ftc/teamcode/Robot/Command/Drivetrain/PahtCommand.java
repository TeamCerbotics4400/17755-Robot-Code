package org.firstinspires.ftc.teamcode.Robot.Command.Drivetrain;

import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

public class PahtCommand extends CommandBase {
    private Drivetrain drivetrain;
    private PathChain path;
    public PahtCommand(Drivetrain drivetrain, PathChain path) {
        this.drivetrain = drivetrain;
        this.path = path;
    }


    @Override
    public void initialize() {
        drivetrain.followPath(path);
    }

    @Override
    public void execute() {
        drivetrain.update();
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drivetrain.stopFollow();
        }
    }

    @Override
    public boolean isFinished() {
        return drivetrain.finishedPath();
    }
}