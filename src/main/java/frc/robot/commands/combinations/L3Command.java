package frc.robot.commands.combinations;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.subsystems.mechanisms.ElevatorSubsystem;

public class L3Command extends Command {

    //private ShuffleboardTab pivotTab = Shuffleboard.getTab("Pivot");

    private final ElevatorSubsystem elevatorSubsystem;
    public L3Command(ElevatorSubsystem eSubsystem) {
        elevatorSubsystem = eSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
        //pivotSubsystem.setGoal(PivotConstants.kAmpShootPos);
        /*if (!pivotSubsystem.isEnabled()) {
            pivotSubsystem.enable();
        }*/
        SmartDashboard.putNumber("elevatorHeight: ", elevatorSubsystem.getHeightMeters());
        SmartDashboard.putNumber("elevatorHeightFrontEncoder: ", elevatorSubsystem.getHeightMetersFrontEncoder());
        
        SmartDashboard.putNumber("frontMCAppliedOutput: ", elevatorSubsystem.frontMCAppliedOutput());
        SmartDashboard.putNumber("backMCAppliedOutput: ", elevatorSubsystem.backMCAppliedOutput());

        elevatorSubsystem.changeDesiredHeight(ElevatorConstants.Heights.L3);

        
    }

    @Override
    public void execute() {
        //System.out.println("position error: " + m_ArmSubsystem.showPositionError());
        
        //elevatorSubsystem.synchronizeEncoders();
        
        SmartDashboard.putNumber("elevatorHeight: ", elevatorSubsystem.getHeightMeters());
        SmartDashboard.putNumber("elevatorHeightFrontEncoder: ", elevatorSubsystem.getHeightMetersFrontEncoder());

        SmartDashboard.putNumber("frontMCAppliedOutput: ", elevatorSubsystem.frontMCAppliedOutput());
        SmartDashboard.putNumber("backMCAppliedOutput: ", elevatorSubsystem.backMCAppliedOutput());

        /*if (elevatorSubsystem.getHeightMeters() < ElevatorConstants.kL3Height) {
            elevatorSubsystem.reachGoal(ElevatorConstants.kL3Height);
        } else {
            elevatorSubsystem.stopMotors();
        }*/

        //pivotSubsystem.reachSetpoint(0.48); //0.48 vertical, 0.386 com at 0 rad
    }
 
    @Override
    public void end(boolean interrupted) {
        //elevatorSubsystem.stopMotors();
    }
    
}