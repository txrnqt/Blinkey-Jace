package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    VictorSP backLeft = new VictorSP(7);
    VictorSP backRight = new VictorSP(4);
    VictorSP frontLeft = new VictorSP(6);
    VictorSP frontRight = new VictorSP(5);

    public Drive() {
        backLeft.addFollower(frontLeft);
        backRight.addFollower(frontRight);
    }

    public void notDrive(double leftvoltage, double rightvoltage) {
        backLeft.set(leftvoltage);
        backRight.set(rightvoltage);

    }

    public Command driveCommand() {
        return Commands.runEnd(this::notDrive(x,x), () -> stop());
    }
})

