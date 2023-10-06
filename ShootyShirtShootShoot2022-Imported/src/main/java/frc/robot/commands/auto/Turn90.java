// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class Turn90 extends CommandBase {
  public double sumError;
  CANSparkMax front_left;
  CANSparkMax front_right;
  Drivebase drive;
  double gyro;
  Constants constant = new Constants();

  /** Creates a new Turn90. */
  public Turn90(Drivebase subsystem) {
    this.drive = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetGyro();
    drive.setIdleMode();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    gyro = drive.getGyro();

    double error = -90 - gyro;
    double sumError =+ error;
    double power = (-error * constant.turnP)+(sumError *constant.turnI);
    power = MathUtil.clamp(power, 0.0, 0.1);
    sumError = MathUtil.clamp(sumError, -500, 500);
    drive.spin(power,-power);
    
    SmartDashboard.putNumber("gyro", gyro);
    SmartDashboard.putNumber("error", error);
    SmartDashboard.putNumber("power", power);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  return  (gyro >= 88)  && (gyro <= 92) || ((gyro <= -88) && ((gyro >= -92) ));
  }
}
