package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class driveCommand extends Command {

    Drive drive;

    public void Drivecommand(Drive Drive) {
        this.drive = drive;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        drive.drive();
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}    