package org.firstinspires.ftc.teamcode.Robot;

import com.bylazar.panels.PanelsConfig;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Utils.Drawing;

public class TelemetryRobot {
    private Telemetry telemetry;
    private TelemetryManager telemetryManager;

    public TelemetryRobot(Telemetry telemetry) {
        this.telemetry = telemetry;

        telemetryManager = PanelsTelemetry.INSTANCE.getTelemetry();
    }

    public void update() {
        telemetryManager.update(telemetry);
    }
}
