package org.firstinspires.ftc.teamcode.Robot.Command.Drivetrain;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private Drivetrain drivetrain;
    private DoubleSupplier y, x, turn;

    public DriveCommand(
            Drivetrain drivetrain,
            DoubleSupplier y,
            DoubleSupplier x,
            DoubleSupplier turn
    ) {
        this.drivetrain = drivetrain;
        this.y = y;
        this.x = x;
        this.turn = turn;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.startTeleOp();
    }

    @Override
    public void execute() {
        drivetrain.setDrive(
                y.getAsDouble(),
                x.getAsDouble(),
                turn.getAsDouble()
        );
        drivetrain.update();
    }
}
