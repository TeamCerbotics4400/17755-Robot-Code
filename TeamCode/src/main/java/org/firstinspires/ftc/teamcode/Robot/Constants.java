package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Constants {
    public static class ShooterConstants {
        // Ajusta estos números
        public static final double gearRatio = 10.0; // ejemplo
        public static final double maxDegrees = 120;
        public static final double minDegrees = -120;

        public static double ticksPerRev (DcMotorEx motor) {
            return motor.getMotorType().getTicksPerRev();
        }


    }
}
