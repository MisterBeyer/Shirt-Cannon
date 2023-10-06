// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.Constants;



public class move10Feet extends CommandBase {
  private final Drivebase m_subsystem;
  private Constants constant;
  private double Distance;

  /** Creates a new move10Feet. */
  public move10Feet(Drivebase subsystem, double distance) {
    Distance = distance;
    m_subsystem = subsystem;
   m_subsystem.setIdleMode();
   addRequirements(m_subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.setEncoder();
    //m_subsystem.move(-.20);


    // Pid reset 
    m_subsystem.resetGyro();
    m_subsystem.setIdleMode();
    
    m_subsystem.tankDrive(0.201, -0.2);
    m_subsystem.getEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      // Pid to drive straight
      double gyro = m_subsystem.getGyro();

      double error = -90 - gyro;
      double sumError =+ error;
      double power = (-error * constant.turnP)+(sumError *constant.turnI);
      power = MathUtil.clamp(power, 0.0, 0.1);
      sumError = MathUtil.clamp(sumError, -500, 500);
      m_subsystem.spin(power,-power);
      
      SmartDashboard.putNumber("gyro", gyro);
      SmartDashboard.putNumber("error", error);
      SmartDashboard.putNumber("power", power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
    m_subsystem.setEncoder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_subsystem.getEncoder() > Distance;
  }
}
