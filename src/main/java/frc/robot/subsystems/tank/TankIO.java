package frc.robot.subsystems.tank;

import org.littletonrobotics.junction.AutoLog;

public interface TankIO {

    @AutoLog
    public class tankIOInputs {
        public double tankPositionRad = 0.0;
        public double tankVelocityRadPerSec = 0.0;
        public double tankAppliedVolts = 0.0;
    }

    public default void updateInputs(tankIOInputs inputs) {}


    public default void tankPower(double lPower, double rPower) {}

}
