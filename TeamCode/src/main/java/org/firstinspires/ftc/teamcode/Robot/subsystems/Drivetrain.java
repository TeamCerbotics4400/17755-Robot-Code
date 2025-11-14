package org.firstinspires.ftc.teamcode.Robot.subsystems;

import android.graphics.Paint;

import com.bylazar.field.Style;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.math.Vector;
import com.pedropathing.paths.PathBuilder;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Utils.Drawing;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import java.util.Locale;

public class Drivetrain extends SubsystemBase {
    private Follower follower;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;


    public Drivetrain(HardwareMap hardwareMap, Telemetry telemetry, Pose pose) {
        setSubsystem("Drivetrain");
        this.follower = Constants.createFollower(hardwareMap);

        follower.setStartingPose(pose);
        Drawing.init();
    }

    public void startTeleOp() {follower.startTeleopDrive();}

    public void followPath(PathChain path) {follower.followPath(path, true);}

    public PathBuilder pathBuldier() {return follower.pathBuilder();}

    public boolean finishedPath () {return !follower.isBusy();}

    public void update() {follower.update();}

    public void stopFollow() {follower.breakFollowing();}

    public Follower getFollower() {return follower;}


    public void setDrive(double y, double x, double turn, boolean isRobotCentric) {
        follower.setTeleOpDrive(y, x, turn, isRobotCentric);
    }

    public void setDrive(double y, double x, double turn) {
        follower.setTeleOpDrive(y, x, turn);
    }

    public Pose getPose() {
        return follower.getPose();
    }

    public Vector getVelocity() {
        return follower.getVelocity();
    }

    public Style getStyle() {
        return new Style("", "#3F51B5", 0.0);
    }

    @Override
    public void periodic() {
        String pose = String.format(
                Locale.US,
                "X: %.3f, Y: %.3f, H: %.3f",
                getPose().getY(),
                getPose().getX(),
                getPose().getHeading()
        );

        String velocity = String.format(
                Locale.US,
                "X: %.3f, Y: %.3f, Magnitude: %.3f",
                getVelocity().getXComponent(),
                getVelocity().getYComponent(),
                getVelocity().getMagnitude()
        );

        Drawing.drawRobot(getPose(), getStyle());

        telemetry.addData(getSubsystem(), pose);
        telemetry.addData(getSubsystem(), velocity);
    }
}