package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{

    VictorSP intakeMotor1 = new  VictorSP(1);
    VictorSP intakeMotor2 = new  VictorSP(2);
    public Intake() {
//inverts the motor turn direction (ture = yes)
            intakeMotor2.setInverted(true);
//makes one motor move when another moves
            intakeMotor1.addFollower(intakeMotor2);
    }

    public void setPower(double power) {
        intakeMotor1.set(power);
    }
    
    public void intake() {
        setPower(-0.7);
    }

    public void Outake() {
        setPower(0.7);
    }

    public void stop() {
        setPower(0);
    }

    public Command intakeCommand() {
        return Commands.runEnd(() -> intake(), () -> stop(), this);
    }
}