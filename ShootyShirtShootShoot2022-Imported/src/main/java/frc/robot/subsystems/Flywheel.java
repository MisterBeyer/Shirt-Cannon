package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase{
    private final CANSparkMax Motor0 = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax Motor1 = new CANSparkMax(3, MotorType.kBrushless);

    public Flywheel() {
     //   Motor0.setIdleMode(IdleMode.kBrake);
        //Motor1.setIdleMode(IdleMode.kBrake);
        Motor1.set(-0.75);
        Motor0.set(0.75);
    }

    public void Motorforward(){
        System.out.println(" The flywheel has begun spinning up");
        Motor0.set(0.75);
        Motor1.set(-0.75); 
     }
     public void MotorStop(){
        System.out.println(" The flywheel has stopped");
       Motor0.set(0.0);
       Motor1.set(0.0);
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

