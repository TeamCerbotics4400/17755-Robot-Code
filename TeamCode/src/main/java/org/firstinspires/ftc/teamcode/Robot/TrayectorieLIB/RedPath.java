package org.firstinspires.ftc.teamcode.Robot.TrayectorieLIB;

import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

public class RedPath {
    private static final Pose startPose = new Pose(0, 0, Math.toRadians(90)); // Start Pose of our robot.
    private static final Pose scorePose = new Pose(0, 39.4, Math.toRadians(-180)); // Scoring Pose of our robot. It is facing the goal at a 135 degree angle.
    private static final Pose pickup1Pose = new Pose(50, 50, Math.toRadians(180)); // Highest (First Set) of Artifacts from the Spike Mark.

    public static PathChain pose1(Drivetrain drivetrain) {
        drivetrain.startPose(startPose);

        return drivetrain.pathBuldier()
                .addPath(new BezierLine(startPose, scorePose))
                .setLinearHeadingInterpolation(startPose.getHeading(), scorePose.getHeading())
                .build();
    }

    public static PathChain pose2(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(new BezierLine(scorePose, pickup1Pose))
                .setLinearHeadingInterpolation(scorePose.getHeading(), pickup1Pose.getHeading())
                .build();
    }
}
