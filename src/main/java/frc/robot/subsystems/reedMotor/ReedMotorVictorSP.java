package frc.robot.subsystems.reedMotor;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;

public class ReedMotorVictorSP implements ReedMotorIO {
    private final CANSparkMax smthMotor1 = new CANSparkMax(57, MotorType.kBrushless);
    private final TalonFX smthMotor2 = new TalonFX(51);
    private final DigitalInput limitSwitch = new DigitalInput(8);
    private final RelativeEncoder smthMotor1Encoder = smthMotor1.getEncoder();
    private final StatusSignal<Double> smthMotor2Position;
    private final StatusSignal<Double> smthMotor2Velocety;
    private final StatusSignal<Double> smthMotor2Voltage;

    public ReedMotorVictorSP() {
        smthMotor2Position = smthMotor2.getPosition();
        smthMotor2Velocety = smthMotor2.getVelocity();
        smthMotor2Voltage = smthMotor2.getSupplyVoltage();
    }


    public double encoder() {
        return smthMotor1.get();
    }

    public void setMotorPower(double power) {
        smthMotor1.set(power);
        smthMotor2.set(power);
    }

    public void updateInputs(InnerReedMotorIO inputs) {
        BaseStatusSignal.refreshAll(smthMotor2Position, smthMotor2Velocety, smthMotor2Voltage);
        inputs.smthMotor1Voltage = smthMotor1.getBusVoltage();
        inputs.smthMotor1VelocityRotPerSecond = smthMotor1Encoder.getVelocity();
        inputs.smthMotor1Positon = smthMotor1Encoder.getPosition();
        inputs.limitSwitch = !limitSwitch.get();
    }
}

