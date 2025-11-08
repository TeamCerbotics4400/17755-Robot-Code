package org.firstinspires.ftc.teamcode.Robot;

import com.bylazar.panels.PanelsConfig;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetryRobot {
    private TelemetryManager manager;
    private Telemetry telemetry;

    public TelemetryRobot(Telemetry telemetry) {
        this.telemetry = telemetry;

        manager = PanelsTelemetry.INSTANCE.getTelemetry();
    }

    public void update() {
        manager.update(telemetry);
    }
}
