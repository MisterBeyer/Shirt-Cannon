package frc.robot.commands;

//import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
//dont unplug the ethernet
public class shootything extends CommandBase {
    private Flywheel flywheel;
    //private BooleanSupplier pressed;

    public shootything(Flywheel flywheel) {
        this.flywheel = flywheel;
        //this.pressed = pressed;
        addRequirements(this.flywheel);
    }

      // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //if(pressed.getAsBoolean() == true) 
        flywheel.Motorforward();
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //flywheel.MotorStop();
    }
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
        // Don't know any end conditions to add here, hoping RobotContainer just interupts it
    }
}
