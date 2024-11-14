package frc.robot.subsystems.intake;


import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private IntakeInputsAutoLogged inputs = new IntakeInputsAutoLogged();

    public Intake(IntakeIO io) {
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

