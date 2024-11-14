package frc.robot.subsystems.reedMotor;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReedMotor extends SubsystemBase {
    private ReedMotorIO io;
    private InnerReedMotorIOAutoLogged inputs = new InnerReedMotorIOAutoLogged();

    public ReedMotor() {
        this.io = io;
    }

    @Override
    public void periodic() {
        Logger.processInputs("Intake", inputs);
        io.updateInputs(inputs);
    }

    public void SetMotorVolatge(double power) {
        Logger.recordOutput("Intake/Voltage", power);
        io.setMotorVoltage(power);
    }

    public void MotorOff(double power) {
        Logger.recordOutput("Intake/Voltage", power);
        io.setMotorVoltage(0);
    }
}
