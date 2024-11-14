package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeVictorSP implements IntakeIO {
    private final VictorSP leftIntake = new VictorSP(1);
    private final VictorSP rightIntake = new VictorSP(2);

    public void setMotorPrecentage(double power) {
        rightIntake.setInverted(true);
        leftIntake.addFollower(rightIntake);
        leftIntake.set(power);
    }

    public void intakeInactive() {
        leftIntake.set(0);
    }
}
