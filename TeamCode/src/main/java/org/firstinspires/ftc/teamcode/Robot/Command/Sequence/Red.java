package org.firstinspires.ftc.teamcode.Robot.Command.Sequence;

import com.pedropathing.paths.PathChain;
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
                new PathCommand(drivetrain, RedPath.pose1(drivetrain)),
                new PathCommand(drivetrain, RedPath.pose2(drivetrain))
        );
    }
}
