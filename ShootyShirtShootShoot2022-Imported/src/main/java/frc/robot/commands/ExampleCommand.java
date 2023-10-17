// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivebase;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivebase m_subsystem;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private final BooleanSupplier l_fast;
  private final BooleanSupplier l_slow;
  private double limiter;
 // private XboxController gamePad;
  /**
   * Creates a new ExampleCommand.
   * int booga = 5
   * double marcusIsDumb = .5
   * 2.4
   * boolean true or false
   * string = "why do you have to be so dumb marcus"
   * 
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(Drivebase subsystem, DoubleSupplier left, DoubleSupplier right, BooleanSupplier fast, BooleanSupplier slow) {
    m_subsystem = subsystem;
    m_left = left;
    m_right = right;
    l_fast = fast;
    l_slow = slow;
// gamePad = new XboxController(0);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(l_fast.getAsBoolean() == true){
      limiter = 1;
    }
    else if(l_slow.getAsBoolean() == true){
      limiter = 0.2;
    }
    else{
      limiter = 0.5;
    }
      double speed = -m_left.getAsDouble();
      double turn = m_right.getAsDouble();
      double LeftMove = speed + turn;
      double RightMove = speed - turn;
    m_subsystem.tankDrive(LeftMove*limiter, RightMove*limiter);
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
