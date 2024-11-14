package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.subsystems.intake.IntakeIO;

public class TankVictorSP implements IntakeIO {
    private final VictorSP backLeft = new VictorSP(7);
    private final VictorSP backRight = new VictorSP(4);
    private final VictorSP frontLeft = new VictorSP(6);
    private final VictorSP frontRight = new VictorSP(5);

    public TankVictorSP() {
        backLeft.addFollower(frontLeft);
        frontLeft.setInverted(true);
        backRight.addFollower(frontRight);
    }

    public void tankVolts(double leftVolts, double rightVolts) {
        backLeft.set(leftVolts);
        backRight.set(rightVolts);
    }
}
