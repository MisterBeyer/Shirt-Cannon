// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ReleaseValve;

public class Release extends CommandBase {
  private ReleaseValve ooga;
  /* Creates a new release. */
  public Release() {
    ooga = new ReleaseValve();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override

    
  
  public void initialize() {
    ooga.shoot();

    System.out.println("First release and i hate marcus ");
    // if ( ooga.safety1() == true) {
    //   System.out.println(" safety 1 is on");
    //   if (ooga.safety2() == true) {
    //     System.out.println(" safety 2 is on");

    //     for(int i = 1; i <= 2; i++) {
    //       ooga.shoot();
    //     }
    //   }
    //   else { ooga.safety1();
    //   }

    // }
    // else { ooga.safety2();
    // }
    
  

  }

   // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   // System.out.println(" I hate Marcus for forcing me to code new stuff");
   ooga.shoot();

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
