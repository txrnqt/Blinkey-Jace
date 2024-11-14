package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.Intake;

public class Commands {
    public Command intakeCMD(Intake intake) {
        return Commands.runEnd(this::iintake, () -> intakeStop);
    }
}
