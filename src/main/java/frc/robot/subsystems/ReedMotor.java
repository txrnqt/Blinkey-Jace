package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class ReedMotor {
    public final CANSparkMax smthMoter = new CANSparkMax(58, MotorType.kBrushless);
    private final WPI_TalonSRX smthMoter2 = new WPI_TalonSRX(51);

    public void on() {
        smthMoter.set(1);
        smthMoter2.set(1);
    }

    public void stop() {
        smthMoter.set(0);
        smthMoter2.set(0);
    }

    public Command onCommand() {
        return Commands.runEnd(this::on, () -> stop());
    }
}
