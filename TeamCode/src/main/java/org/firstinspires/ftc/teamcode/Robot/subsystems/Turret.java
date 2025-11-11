package org.firstinspires.ftc.teamcode.Robot.subsystems;

import static org.firstinspires.ftc.teamcode.Robot.Constants.ShooterConstants.maxDegrees;
import static org.firstinspires.ftc.teamcode.Robot.Constants.ShooterConstants.minDegrees;
import static org.firstinspires.ftc.teamcode.Robot.Constants.ShooterConstants.ticksPerRev;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret extends SubsystemBase {
    private DcMotorEx turret;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Turret(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        turret = hardwareMap.get(DcMotorEx.class, "Turret");
        turret.setDirection(DcMotorSimple.Direction.FORWARD);
        turret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private int degreesToTicks(double degrees) {
        return (int)((degrees / 360.0) * ticksPerRev(turret));
    }

    public void moveToDegrees(double degrees, double power) {
        if (degrees > maxDegrees) degrees = maxDegrees;
        if (degrees < minDegrees) degrees = minDegrees;

        int target = degreesToTicks(degrees);

        turret.setPower(power);
        turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        turret.setTargetPosition(target);
    }

    public void stop() {
        turret.setPower(0.0);
        turret.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}