package org.firstinspires.ftc.teamcode.Robot.OpMode.Test;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Shooter;

@TeleOp(name = "Shooter-Beta", group = "Test")
@Configurable
public class ShooterTeleOp extends CommandOpMode {
    private Shooter shooter;
    private TelemetryManager panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();

    private InstantCommand shoot (Shooter shooter, int rpm) {
        return new InstantCommand(() -> {
            shooter.setRPM(rpm);
        });
    }

    @Override
    public void initialize() {
        shooter = new Shooter(hardwareMap, telemetry);
        register(shooter);

        GamepadEx gamepadEx = new GamepadEx(gamepad1);

        gamepadEx.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(shoot(shooter, 100))
                .whenReleased(shooter::stop);


    }
}
