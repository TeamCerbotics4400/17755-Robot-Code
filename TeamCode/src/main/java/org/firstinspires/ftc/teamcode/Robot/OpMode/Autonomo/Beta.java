package org.firstinspires.ftc.teamcode.Robot.OpMode.Autonomo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Robot.Command.Sequence.Red;
import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

@Autonomous(name = "Beta-Autnomo", group = "Test")
public class Beta extends CommandOpMode {
    @Override
    public void initialize() {
        Drivetrain drivetrain = new Drivetrain(hardwareMap, telemetry);
        register(drivetrain);

        Red sequence = new Red(drivetrain);

        schedule(sequence);
    }
}
