package org.firstinspires.ftc.teamcode.Robot.TrayectorieLIB;

import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

import org.firstinspires.ftc.teamcode.Robot.subsystems.Drivetrain;

public class RedPath {
    public static Pose startPose = new Pose(56.000, 8.000, Math.toRadians(90));
    public static Pose finalyPose = new Pose(59.309, 84.432, Math.toRadians(138));

    public static PathChain path1(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 8.000),
                                new Pose(41.957, 39.885),
                                new Pose(34.446, 35.223),
                                new Pose(14.763, 35.741)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .build();
    }

    public static PathChain path2(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierLine(new Pose(14.763, 35.741), new Pose(68.892, 10.878))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(120))
                .setReversed()
                .build();
    }

    public static PathChain path3(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierCurve(
                                new Pose(68.892, 10.878),
                                new Pose(56.460, 64.230),
                                new Pose(11.914, 59.309)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .build();
    }

    public static PathChain path4(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierCurve(
                                new Pose(11.914, 59.309),
                                new Pose(69.669, 48.173),
                                new Pose(59.309, 84.432)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(138))
                .setReversed()
                .build();
    }

    public static PathChain path5(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierLine(new Pose(59.309, 84.432), new Pose(17.353, 83.914))
                )
                .setTangentHeadingInterpolation()
                .build();
    }

    public static PathChain path6(Drivetrain drivetrain) {
        return drivetrain.pathBuldier()
                .addPath(
                        new BezierLine(new Pose(17.353, 83.914), new Pose(59.309, 84.432))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(138))
                .setReversed()
                .build();
    }

}
