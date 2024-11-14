package frc.robot.subsystems.reedMotor;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class ReedMotorVictorSP {
    private final CANSparkMax smthMoter1 = new CANSparkMax(57, MotorType.kBrushless);
    private final TalonFX smthMotor2 = new TalonFX(51);

    public ReedMotorVictorSP() {}

    public void reedPowa(double power) {
        smthMoter1.set(power);
        smthMotor2.set(power);
    }

    public void reedSleep() {
        smthMoter1.set(0);
        smthMotor2.set(0);
    }
}
