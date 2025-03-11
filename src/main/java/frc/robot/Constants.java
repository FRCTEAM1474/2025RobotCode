// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.Second;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Distance;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class DriverConstants {
    public static final int kDriverControllerPort = 0;
    public static final double kSensitivity = 3;
    public static final double DEADBAND = 0.3;
  }

  public static class OperatorConstants {

  }

  public static class SwerveConstants {
    public static final double MAX_SPEED = Units.feetToMeters(14.5);
    public static final double ROBOT_MASS = Units.lbsToKilograms(47);
    public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(3.35)), ROBOT_MASS);
    public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
    
    
  }

  public static class VisionConstants {
    public static final Pose3d LIMELIGHT_POSE = new Pose3d(0.0,
                                                            -0.2744,
                                                            0.2286,
                                                            new Rotation3d(Units.degreesToRadians(0), Units.degreesToRadians(32.005), Units.degreesToRadians(90)));
  }

  public static class MotorLimit {
    public static class Neo {
      public static final int stall = 60;
      public static final int free  = 40;
      public static final int stallRPM = 0; // 0 for linear limit
    }
    public static class Neo550 {
      public static final int stall = 40;
      public static final int free  = 20;
      public static final int stallRPM = 0; // 0 for linear limit
    }
  }

  public static class PivotConstants {
    public static final int kPivotMotorPort = 50;
    public static final double kMaxVelocityRadPerSecond = 0.25;
    public static final double kGVolts = 0.27; //calculated as 0.22 without coral
    public static final double kVVoltSecondPerRad = 0.53;
    public static final double kAVoltSecondSquaredPerRad = 0.01 / (Math.PI*2);
    public static final double kSVolts = 0.8; //try 0.8 if it doesn't work
    public static final double kP = 15;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kMaxAccelerationRadPerSecSquared = 1;
    //public static final double kArmOffsetRads = Math.PI/2;
    public static final double kEncoderDistancePerRotation = 2*Math.PI;
    public static final double kPivotReduction = 27;
    public static final double kPivotAllowedClosedLoopError = (Rotations.of((Degrees.of(0.01)).in(Rotations))).in(Rotations);
    public static boolean pivotMotorInverted = false;

    public static final double kVerticalRot = 0.48;
    public static final double kStowRot = 0.07;
    public static final double kOutRot = 0.55; //TODO: get value
    public static final double kInRot = 0.55; //TODO: get value
    public static final double kClimbRot = 0.55; //TODO: get value
    public static final double kScoreRot = 0.37;
  }
  
  public static class ElevatorConstants {
    public static final int kBackMotorPort = 30;
    public static final int kFrontMotorPort = 31;

    public static final double kElevatorKp = 26.722;
    public static final double kElevatorKi = 0;
    public static final double kElevatorKd = 1.6047;

    public static final double kElevatorkS = 0.01964; // volts (V)
    public static final double kElevatorkV = 3.894; // volt per velocity (V/(m/s))
    public static final double kElevatorkA = 0.173; // volt per acceleration (V/(m/s²))
    public static final double kElevatorkG = 0.91274; // volts (V)

    public static final double kElevatorGearing    = 8.45;
    public static final double kElevatorDrumRadius = Units.inchesToMeters(1.0);
    public static final double kCarriageMass       = 4.0; // kg

    // Encoder is reset to measure 0 at the bottom, so minimum height is 0.
    public static final Distance kLaserCANOffset    = Inches.of(3);
    public static final Distance kStartingHeightSim = Meters.of(0);
    public static final Distance kMinElevatorHeight = Meters.of(0.0);
    public static final Distance kMaxElevatorHeight = Meters.of(1.6764);


    public static double kElevatorRampRate = 0.1;
    public static int    kElevatorCurrentLimit = 40;
    public static double kMaxVelocity = Meters.of(4).per(Second).in(MetersPerSecond);
    public static double kMaxAcceleration = Meters.of(8).per(Second).per(Second).in(MetersPerSecondPerSecond);
  }

}
