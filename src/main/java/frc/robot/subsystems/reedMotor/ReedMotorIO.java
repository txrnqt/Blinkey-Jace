package frc.robot.subsystems.reedMotor;

import org.littletonrobotics.junction.AutoLog;

public interface ReedMotorIO {

    @AutoLog
    public static class InnerReedMotorIO {
        public double smthMotor1VelocityRotPerSecond;
        public double smthMotor1Voltage;
    }

    public default double encoder() {
        return 0;
    }

    public default void setMotorPower(double power) {}

    public default void setMotorPercentage(double percent) {}

    public default void updateInputs(InnerReedMotorIO inputs) {}
}
// reed the destroyer did not destory this
