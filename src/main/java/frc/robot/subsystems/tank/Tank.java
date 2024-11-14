package frc.robot.subsystems.tank;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tank extends SubsystemBase {
    private TankIO io;
    private tankIOInputsAutoLogged inputs = new tankIOInputsAutoLogged();

    public Tank(TankIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        Logger.processInputs("Tank", inputs);
        io.updateInputs(inputs);
    }

    public void tankPower(double leftVolts, double rightVolts) {
        Logger.recordOutput("Tank/leftVolts", leftVolts);
        Logger.recordOutput("Tank/rightVolts", rightVolts);
        io.setDriveVoltage(leftVolts, rightVolts);
    }
}
