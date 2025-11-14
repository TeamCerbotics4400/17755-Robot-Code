package org.firstinspires.ftc.teamcode.Robot.OpMode.Test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Robot.Command.Drivetrain.DriveCommand;
import org.firstinspires.ftc.teamcode.Robot.TrayectorieLIB.RedPath;
import org.firstinspires.ftc.teamcode.Robot.Utils.Drawing;
import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

@TeleOp(name = "Drive-Beta", group = "Test")
public class DriveTest extends CommandOpMode {
    @Override
    public void initialize() {
        Drivetrain drivetrain = new Drivetrain(hardwareMap, telemetry, RedPath.finalyPose);
        register(drivetrain);

        GamepadEx player = new GamepadEx(gamepad1);

        drivetrain.setDefaultCommand(new DriveCommand(
                drivetrain,
                () -> -player.getLeftY(),
                player::getLeftX,
                player::getRightX,
                true
        ));

        schedule(new RunCommand(() -> {
            telemetry.update();
            Drawing.sendPacket();
        }));
    }
}
