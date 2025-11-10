package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MyRobot extends Robot {


    public enum OpModeType {
        TELEOP, AUTO
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type, HardwareMap hardwareMap, Telemetry telemetry) {
        if (type == OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    /*
     * Initialize teleop or autonomous, depending on which is used
     */
    public void initTele() {

    }

    public void initAuto() {
        // initialize auto-specific scheduler
    }
}
