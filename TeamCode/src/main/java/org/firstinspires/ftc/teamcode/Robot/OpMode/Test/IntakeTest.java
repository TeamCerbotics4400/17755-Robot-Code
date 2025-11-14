package org.firstinspires.ftc.teamcode.Robot.OpMode.Test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Intake;

@TeleOp(name = "Intake-Beta", group = "Test")
public class IntakeTest extends CommandOpMode {
    private InstantCommand FORWARD(Intake intake) {
        return new InstantCommand(() -> {
            intake.setPower(0.5);
        });
    }

    private InstantCommand REVERSE(Intake intake) {
        return new InstantCommand(() -> {
           intake.setPower(-0.5);
        });
    }

    @Override
    public void initialize() {
        Intake intake = new Intake(hardwareMap, telemetry);
        register(intake);

        GamepadEx gamepadEx = new GamepadEx(gamepad1);

        gamepadEx.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(FORWARD(intake))
                .whenReleased(new InstantCommand(intake::stop));

        gamepadEx.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(REVERSE(intake))
                .whenReleased(new InstantCommand(intake::stop));
    }
}
