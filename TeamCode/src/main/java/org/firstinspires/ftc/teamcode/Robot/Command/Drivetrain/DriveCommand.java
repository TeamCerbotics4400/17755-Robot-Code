package org.firstinspires.ftc.teamcode.Robot.Command.Drivetrain;

import com.pedropathing.geometry.Pose;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private Drivetrain drivetrain;
    private DoubleSupplier y, x, turn;
    private boolean isFieldCentric;

    public DriveCommand(
            Drivetrain drivetrain,
            DoubleSupplier y,
            DoubleSupplier x,
            DoubleSupplier turn,
            boolean isFieldCentric
    ) {
        this.drivetrain = drivetrain;
        this.y = y;
        this.x = x;
        this.turn = turn;
        this.isFieldCentric = isFieldCentric;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.startTeleOp();
    }

    @Override
    public void execute() {
        if (isFieldCentric) {
            drivetrain.setDrive(
                    y.getAsDouble(),
                    x.getAsDouble(),
                    turn.getAsDouble(),
                    false
            );
        } else {
            drivetrain.setDrive(
                    y.getAsDouble(),
                    x.getAsDouble(),
                    turn.getAsDouble()
            );
        }
    }
}