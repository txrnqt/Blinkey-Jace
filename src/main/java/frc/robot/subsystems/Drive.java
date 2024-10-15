package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    static VictorSP backLeft = new VictorSP(7);
    static VictorSP backRight = new VictorSP(4);
    VictorSP frontLeft = new VictorSP(6);
    VictorSP frontRight = new VictorSP(5);
    double left = 0;
    double right = 0;

    public Drive() {
        backLeft.addFollower(frontLeft);
        backRight.addFollower(frontRight);
    }

    public void drive() {
        backLeft.set(left);
        backRight.set(right);
    }

    public void turn() {
        backLeft.set(-0.5);
        backRight.set(0.5);
    }

    public void stop() {
        backLeft.set(0);
        backRight.set(0);
    }

    public Command driveCommand() {
        return Commands.runEnd(this::drive, () -> stop(), this);
    }

    public Command turnCommand() {
        return Commands.runEnd(this::turn, () -> stop());
    }

}
