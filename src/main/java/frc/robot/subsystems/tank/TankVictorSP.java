package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class TankVictorSP implements TankIO {
    private final VictorSP backLeft = new VictorSP(7);
    private final VictorSP backRight = new VictorSP(4);
    private final VictorSP frontLeft = new VictorSP(6);
    private final VictorSP frontRight = new VictorSP(5);

    public TankVictorSP() {
        backLeft.addFollower(frontLeft);
        frontLeft.setInverted(true);
        backRight.addFollower(frontRight);
    }

    public void tankPower(double leftPower, double rightPower) {
        backLeft.set(leftPower);
        backRight.set(rightPower);
    }

    public void tankIOInputs() {}


}
