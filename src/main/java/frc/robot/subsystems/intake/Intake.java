package frc.robot.subsystems.intake;


import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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

    public void IntakeON() {
        SetMotorVolatge(1);
    }

    public void MotorOff() {
        io.setMotorVoltage(0);
    }

    public Command intakeCMD(double power) {
        return Commands.startEnd(() -> {
            SetMotorVolatge(power);
        }, () -> SetMotorVolatge(0), this);
    }

    public Command OuttakeCMD(double power) {
        return Commands.startEnd(() -> {
            SetMotorVolatge(-power);
        }, () -> {
            SetMotorVolatge(0);
        }, this);
    }
}

