package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    static VictorSP intakeMotor1 = new VictorSP(1);
    VictorSP intakeMotor2 = new VictorSP(2);


    public Intake() {
        // inverts the motor turn direction (ture = yes)
        intakeMotor2.setInverted(true);
        // makes one motor move when another moves
        intakeMotor1.addFollower(intakeMotor2);
    }

    public static void setPowers(double power) {
        intakeMotor1.set(power);
    }

    public void intake() {
        setPowers(-0.7);
    }

    public void Outake() {
        setPowers(0.7);
    }

    public void stop() {
        setPowers(0);
    }



    public Command intakeCommand() {
        return Commands.runEnd(this::intake, () -> stop());

    }

    public Command outakeCommand() {
        return Commands.runEnd(this::Outake, () -> stop());
    }



}

