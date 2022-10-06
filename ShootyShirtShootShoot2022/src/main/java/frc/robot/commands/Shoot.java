// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.subsystems.Cannon;
public class Shoot extends CommandBase {
  
  private Cannon solid;

  /** Creates a new Shoot. */
  public Shoot() {
    solid = new Cannon();
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    solid.toggleShoot();
  }
  public void execute() {
   // System.out.println("Coding team is better then everybody else ");
    
   }
  @Override
  public boolean isFinished() {
    return true;
  }
}
