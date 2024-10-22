package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Drive extends SubsystemBase {
    VictorSP backLeft = new VictorSP(7);
    VictorSP backRight = new VictorSP(4);
    VictorSP frontLeft = new VictorSP(6);
    VictorSP frontRight = new VictorSP(5);

    public Drive() {
        backLeft.addFollower(frontLeft);
        frontLeft.setInverted(true);
        backRight.addFollower(frontRight);
    }

    public void notDrive(double leftvoltage, double rightvoltage) {
        backLeft.set(leftvoltage);
        backRight.set(rightvoltage);

    }

    public Command teleopSwerve(CommandXboxController controller) {
        return this.run(() -> notDrive(controller.getLeftY(), controller.getRightY()));
    }
}

