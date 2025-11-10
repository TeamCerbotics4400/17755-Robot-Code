package org.firstinspires.ftc.teamcode.Robot.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Locale;

public class Shooter extends SubsystemBase {
    private MotorEx above, below;
    private MotorGroup shotter;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        setSubsystem("Shooter");
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        above = new MotorEx(hardwareMap, "Above");
        above.setInverted(true);

        below = new MotorEx(hardwareMap, "Below");
        below.setInverted(false);

        shotter = new MotorGroup(above, below);
        shotter.setRunMode(Motor.RunMode.RawPower);
        shotter.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        shotter.setVeloCoefficients(0.5, 1, 0);
    }

    public void setRPM(int RPM) {
        double TICKS_PER_REV = 28.0; // REV HD Hex motor (no gearbox)
        double gearRatio = 1.1818;

        double targetTicksPerSeconds = (RPM * TICKS_PER_REV * gearRatio);
        shotter.set(targetTicksPerSeconds);
    }

    public void setPower(double power) {
        shotter.set(power);
    }

    public void stop() {
        shotter.stopMotor();
    }

    public double getRPM(MotorEx motorEx) {
        double ticksPerSecond = motorEx.getVelocity();
        double ticksREV = 20.0;
        double gearratio = 1.1018;

        double rpm = (ticksPerSecond * 60) / (ticksREV * gearratio);
        return rpm;
    }

    @Override
    public void periodic() {
        String data = String.format(
                Locale.US,
                "above: %.3f, below: %.3f",
                getRPM(above),
                getRPM(below)
        );

        telemetry.addData(getSubsystem(), data);
    }
}
