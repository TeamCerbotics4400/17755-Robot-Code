package org.firstinspires.ftc.teamcode.Robot.Command.Sequence;

import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Robot.Command.Drivetrain.PathCommand;
import org.firstinspires.ftc.teamcode.Robot.TrayectorieLIB.RedPath;
import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

public class Red extends SequentialCommandGroup {
    private Drivetrain drivetrain;

    public Red(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);

        addCommands(
                new PathCommand(drivetrain, RedPath.path1(drivetrain)),
                new ParallelCommandGroup(
                        new PathCommand(drivetrain, RedPath.path2(drivetrain))

                ),
                new PathCommand(drivetrain, RedPath.path3(drivetrain)),
                new PathCommand(drivetrain, RedPath.path4(drivetrain)),
                new PathCommand(drivetrain, RedPath.path5(drivetrain)),
                new PathCommand(drivetrain, RedPath.path6(drivetrain))
        );
    }
}
