package frc.robot.subsystems.reedMotor;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class ReedMotorVictorSP implements ReedMotorIO {
    private final CANSparkMax smthMotor1 = new CANSparkMax(57, MotorType.kBrushless);
    private final TalonFX smthMotor2 = new TalonFX(51);

    public ReedMotorVictorSP() {}

    public double encoder() {
        return smthMotor1.get();
    }

    public void setMotorPower(double power) {
        smthMotor1.set(power);
        smthMotor2.set(power);
    }

    public void updateInputs(InnerReedMotorIO inputs) {
        inputs.smthMotor1Voltage = smthMotor1.getBusVoltage();
        inputs.smthMotor1VelocityRotPerSecond = smthMotor1.getEncoder().getVelocity();
        
    }
}
