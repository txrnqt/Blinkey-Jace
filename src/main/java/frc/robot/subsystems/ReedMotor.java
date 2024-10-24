package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class ReedMotor {
    CANSparkMax smthMoter = new CANSparkMax(57, MotorType.kBrushless);
    TalonFX smthMoter2 = new TalonFX(51);
    private static double lastAtSetPoint;

    public void on() {
        smthMoter.set(1);
        smthMoter2.set(1);
    }

    public static boolean changeColor() {
        return lastAtSetPoint < Timer.getFPGATimestamp() - 0.1;
    }


    public void stop() {
        smthMoter.set(0);
        smthMoter2.set(0);
    }

    public Command onCommand() {
        return Commands.runEnd(this::on, () -> stop());
    }
}
