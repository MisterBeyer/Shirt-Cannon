// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Piston;

public class ElevatePiston extends CommandBase {
  private Piston piston;
  /** Creates a new ElevatePiston. */
  public ElevatePiston() {
    // Use addRequirements() here to declare subsystem dependencies.
    piston = new Piston();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println(" Eletrical team will electrocute themselves ");

    piston.elevate();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    System.out.println(" mecanical team are going to stab themselves somehow ");
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
