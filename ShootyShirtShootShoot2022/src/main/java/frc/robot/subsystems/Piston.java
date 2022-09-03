// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Piston extends SubsystemBase {
 private DoubleSolenoid test;
 // Solenoid solidPCM;
  /** Creates a new Piston. */
  public Piston(pistons up) {
    // CHANGE THE I.Ds ONCE WE GET IT HOOKED UP
    
    switch(up) {
      case E_ELEVATE: 
      test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,6);
      break;
      case E_CANNON:
      test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,2,3);
      break;
      default: 
      System.out.println("DEFAULT GOT HIT");
    }
    
    //Sets up the piston solidnoide needs to be given IDs once we connect the robot
    // solidPCM = new Solenoid(Id,PneumaticsModuleType.CTREPCM, Id);
    
  }
   public enum pistons {
     E_ELEVATE,
     E_CANNON
     
   }
   public void elevate() {
     test.set(Value.kForward);
     System.out.println(test.get());
     
   }

   public void down() {
    test.set(Value.kReverse);
    System.out.println(test.get());

   }
   public void off() {
     test.set(Value.kOff);
   }

   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
