package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class intakeCommand extends Command{
    
    Intake intake;


    public void IntakeCommand(Intake Intake) {
        this.intake = intake;
    }


    @Override
    public void initialize() {}

    @Override
    public void execute() {
        intake.intake();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
