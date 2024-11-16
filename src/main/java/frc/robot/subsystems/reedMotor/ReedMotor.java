package frc.robot.subsystems.reedMotor;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReedMotor extends SubsystemBase {
    private ReedMotorIO io;
    private InnerReedMotorIOAutoLogged inputs = new InnerReedMotorIOAutoLogged();

    public ReedMotor(ReedMotorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        Logger.processInputs("Intake", inputs);
        io.updateInputs(inputs);
    }

    public void SetMotorPower(double power) {
        Logger.recordOutput("Intake/Voltage", power);
        io.setMotorPower(power);
    }

    public Command ReedON(double power) {
        return Commands.startEnd(() -> {
            SetMotorPower(power);
        }, () -> {
            SetMotorPower(0);
        }, this);
    }
}
