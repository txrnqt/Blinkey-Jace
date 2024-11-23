package frc.robot.subsystems.reedMotor;

import org.littletonrobotics.junction.AutoLog;

public interface ReedMotorIO {

    @AutoLog
    public static class InnerReedMotorIO {
        public double smthMotor1VelocityRotPerSecond;
        public double smthMotor1Voltage;
        public double smthMotor1Positon;
        public double smthMotor2Position;
        public double smthMotor2Velocety;
        public double smthMotor2Voltage;
        public boolean limitSwitch;
    }

    public default double encoder() {
        return 0;
    }

    public default void setMotorPower(double power) {}

    public default void setMotorPercentage(double percent) {}

    public default void updateInputs(InnerReedMotorIO inputs) {}
}
// reed the destroyer did not destory this
