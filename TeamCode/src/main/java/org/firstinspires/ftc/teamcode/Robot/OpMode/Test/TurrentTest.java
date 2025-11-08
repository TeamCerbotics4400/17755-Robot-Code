package org.firstinspires.ftc.teamcode.Robot.OpMode.Test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Turret;

@TeleOp(name = "Turrent-test", group = "Test")
public class TurrentTest extends CommandOpMode {
    private InstantCommand Forward(Turret turret) {
        return new InstantCommand(() -> {
            turret.setPower(0.5);
        });
    }

    private InstantCommand Reverse(Turret turret) {
        return new InstantCommand(() -> {
            turret.setPower(-0.5);
        });
    }

    @Override
    public void initialize() {
        Turret turret = new Turret(hardwareMap, telemetry);
        register(turret);

        GamepadEx gamepadEx = new GamepadEx(gamepad1);

        gamepadEx.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(Forward(turret))
                .whenReleased(turret::stop);

        gamepadEx.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(Reverse(turret))
                .whenReleased(turret::stop);
    }
}
