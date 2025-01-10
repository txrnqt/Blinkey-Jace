package frc.robot.subsystems.reedMotor;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.DigitalInput;

public class ReedMotorVictorSP implements ReedMotorIO {
    private final SparkMax smthMotor1 = new SparkMax(57, MotorType.kBrushless);
    private final TalonFX smthMotor2 = new TalonFX(51);
    private final DigitalInput limitSwitch = new DigitalInput(8);
    private final RelativeEncoder smthMotor1Encoder = smthMotor1.getEncoder();
    private final StatusSignal<Angle> smthMotor2Position;
    private final StatusSignal<AngularVelocity> smthMotor2Velocety;
    private final StatusSignal<Voltage> smthMotor2Voltage;

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

