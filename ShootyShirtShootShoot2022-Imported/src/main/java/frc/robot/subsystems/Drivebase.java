package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    Constants constant = new Constants();
    private final CANSparkMax front_Left = new CANSparkMax(1, MotorType.kBrushless);
    private final CANSparkMax back_Left = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax front_Right = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax back_Right = new CANSparkMax(4, MotorType.kBrushless);

    public Drivebase()
    {
        back_Left.follow(front_Left);
        back_Right.follow(front_Right);
        front_Left.setIdleMode(IdleMode.kBrake);
        front_Right.setIdleMode(IdleMode.kBrake);
        back_Left.setIdleMode(IdleMode.kBrake);
        back_Right.setIdleMode(IdleMode.kBrake);
    }

    public void tankDrive(double left_Input, double right_Input) {
        
        
        front_Left.set(MathUtil.applyDeadband(left_Input, 0.02));
        front_Right.set(MathUtil.applyDeadband(right_Input, 0.02));
    }
    public void setIdleMode() {
        front_Left.setIdleMode(IdleMode.kBrake);
        front_Right.setIdleMode(IdleMode.kBrake);
        back_Left.setIdleMode(IdleMode.kBrake);
        back_Right.setIdleMode(IdleMode.kBrake);
    }
    public void setEncoder(){
        front_Left.getEncoder().setPosition(0);
        front_Right.getEncoder().setPosition(0);
    
      }   
      public double getEncoder() {
        return front_Left.getEncoder().getPosition() * constant.inchesPerRev;
        
       }
       public void move(double power) {
        front_Left.set(power);
             front_Right.set(power);
            back_Left.set(power);
            back_Right.set(power);
      }
}