package frc.robot.subsystems;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase{
    private final CANSparkMax Motor0 = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax Motor1 = new CANSparkMax(1, MotorType.kBrushless);
    
    private final CANSparkMax Pusher0 = new CANSparkMax(7, MotorType.kBrushless);
    private final CANSparkMax Pusher1 = new CANSparkMax(8, MotorType.kBrushless);

    public Flywheel() {
      Motor0.setIdleMode(IdleMode.kCoast);
      Motor1.setIdleMode(IdleMode.kCoast);

      Pusher0.set(0.1);
      Pusher1.set(0.1);
    }

    public void Motorforward(){
        //System.out.println(" The flywheel has begun spinning up");
        Motor0.set(0.80);
        Motor1.set(-0.80);
        
        SmartDashboard.putNumber("Motor0Amps", Motor0.getOutputCurrent());
        SmartDashboard.putNumber("Motor1Amps", Motor1.getOutputCurrent());
        SmartDashboard.putNumber("Pusher0Amps", Pusher0.getOutputCurrent());
        SmartDashboard.putNumber("Pusher1Amps", Pusher1.getOutputCurrent());

        //I might be done guys
        //He might not be either
     }
     public void MotorStop(){
      //System.out.println(" The flywheel has stopped");
      Motor0.set(0.0);
      Motor1.set(0.0);

      SmartDashboard.putNumber("Motor0Amps", Motor0.getOutputCurrent());
      SmartDashboard.putNumber("Motor1Amps", Motor1.getOutputCurrent());
       //Motor01.set(ControlMode.PercentOutput, 0);
        //Motor02.set(ControlMode.PercentOutput, 0);
     }
     
    // My code is perfect 
    // I wish
    //          - Honda Civic [2009]


     @Override
     public void periodic() {
      //Motor1.set(-0.1);
       // This method will be called once per scheduler run
     }
}

