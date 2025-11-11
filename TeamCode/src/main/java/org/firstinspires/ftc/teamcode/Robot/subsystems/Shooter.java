package org.firstinspires.ftc.teamcode.Robot.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Locale;

public class Shooter extends SubsystemBase {
    private DcMotorEx above, below;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        setSubsystem("Shooter");
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        above = hardwareMap.get(DcMotorEx.class, "Above");
        above.setDirection(DcMotorSimple.Direction.FORWARD);
        above.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        above.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients());

        below = hardwareMap.get(DcMotorEx.class, "Below");
        below.setDirection(DcMotorSimple.Direction.FORWARD);
        below.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        below.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients());
    }

    public void setPower(double power) {
        above.setPower(power);
        below.setPower(power);
    }

    public void stop() {
        above.setPower(0.0);
        below.setPower(0.0);
    }

    public void setRPM(int RPM) {
        double TICKS_PER_REV = 28.0; // REV HD Hex motor (no gearbox)
        double gearRatio = 1.1818;

        double targetTicksPerSeconds = (RPM * TICKS_PER_REV * gearRatio);
        above.setPower(targetTicksPerSeconds);
        below.setPower(targetTicksPerSeconds);
    }

    public double getRPM(DcMotorEx motorEx) {
        double ticksREV = 20.0;
        double gearRatio = 1.1018;

        return  (motorEx.getVelocity() * 60) / (ticksREV * gearRatio);
    }

    @Override
    public void periodic() {
        String data = String.format(
                Locale.US,
                "%s: %.3f, %s: %.3f",
                above.getDeviceName(),
                getRPM(above),
                below.getDeviceName(),
                getRPM(below)
        );

        telemetry.addData(getSubsystem(), data);
    }
}
