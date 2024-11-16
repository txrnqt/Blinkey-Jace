package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeVictorSP implements IntakeIO {
    private final VictorSP leftIntake = new VictorSP(1);
    private final VictorSP rightIntake = new VictorSP(2);

    public IntakeVictorSP() {
        rightIntake.setInverted(true);
        leftIntake.addFollower(rightIntake);
    }

    public void setMotorPrecentage(double percent) {
        leftIntake.set(percent);
    }

    public void intakeInactive() {
        leftIntake.set(0);
    }
}
