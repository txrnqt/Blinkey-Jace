package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    @AutoLog
    public static class IntakeInputs {
        public double intakeVelocityRotPerSecond;
    }

    public default void setMotorPower(double power) {}


    public default void updateInputs(IntakeInputs inputs) {}

}
