// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivebase;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.move10Feet;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.commands.move10Feet;
import frc.robot.subsystems.Drivebase;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */  

public class RobotContainer {
  private move10Feet move10feet;

  private Drivebase drivebase = new Drivebase();

  private final XboxController gamePad;

 // private final Compressor compressor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
   // compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

    gamePad = new XboxController(0);
    
    configureButtonBindings();
    // Might have to chang raw axis 5 to 4 since 5 is forward and backward but 4 is left and right 
    drivebase.setDefaultCommand(new ExampleCommand(drivebase, () -> gamePad.getRawAxis(1), () -> gamePad.getRawAxis(4), () -> gamePad.getLeftBumper(), () -> gamePad.getRightBumper()));
    // Set up compressor
    
      // compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
      // compressor.enableDigital();

    
  }

  /*
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
// this activates the shoot command also might've gotte nthe button port wrong 

   // new JoystickButton(gamePad, 2).whenPressed(new Shoot());
   // new JoystickButton(gamePad, 3).whenPressed(new ElevatePiston());
    

    

    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
    public Command getAutonomousCommand(){
      return new move10Feet(drivebase);
      }
    // An ExampleCommand will run in autonomous
    
  }


