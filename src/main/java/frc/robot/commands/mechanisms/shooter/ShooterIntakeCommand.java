package frc.robot.commands.mechanisms.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.mechanisms.ShooterSubsystem;

public class ShooterIntakeCommand extends Command {

    private final ShooterSubsystem m_ShooterSubsystem;
    //private final CommandXboxController operatorXbox;
    public ShooterIntakeCommand(ShooterSubsystem subsystem/*, CommandXboxController operator*/) {
        m_ShooterSubsystem = subsystem;
        //operatorXbox = operator;
        addRequirements(m_ShooterSubsystem);
    }

    @Override
    public void initialize() {
        if (!m_ShooterSubsystem.hasCoral()) {
            m_ShooterSubsystem.guidedShoot(ShooterConstants.kIntakeSpeed);
        }
    }

    @Override
    public void execute() {
        if (m_ShooterSubsystem.hasCoral()) {
            m_ShooterSubsystem.stop();
        }
    }

    @Override
    public void end (boolean interrupted) {
        m_ShooterSubsystem.stop();
    }

    
}