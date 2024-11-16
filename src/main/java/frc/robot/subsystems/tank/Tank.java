package frc.robot.subsystems.tank;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Tank extends SubsystemBase {
    private TankIO io;
    private tankIOInputsAutoLogged inputs = new tankIOInputsAutoLogged();

    public Tank(TankIO tankIO) {
        this.io = tankIO;
    }

    @Override
    public void periodic() {
        Logger.processInputs("Tank", inputs);
        io.updateInputs(inputs);
    }

    public void tankPower(double leftPower, double rightPower) {
        Logger.recordOutput("Tank/leftVolts", leftPower);
        Logger.recordOutput("Tank/rightVolts", rightPower);
        io.setDrivePower(leftPower, rightPower);
    }

    public Command tankCMD(CommandXboxController controller) {
        return this.run(() -> tankPower(controller.getLeftY(), controller.getRightY()));
    }

}
