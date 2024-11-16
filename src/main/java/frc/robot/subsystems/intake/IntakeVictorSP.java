package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeVictorSP implements IntakeIO {
    private final VictorSP leftIntake = new VictorSP(1);
    private final VictorSP rightIntake = new VictorSP(2);

    public IntakeVictorSP() {
        rightIntake.setInverted(true);
        leftIntake.addFollower(rightIntake);
    }

    public void updateInputs() {}

    public void setMotorPower(double power) {
        leftIntake.set(power);
    }

    public void intakeInactive() {
        leftIntake.set(0);
    }
}
