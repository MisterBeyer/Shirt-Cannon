package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;

public class TableAuto extends SequentialCommandGroup{
    private Turn90 turn90;
    private move10Feet move110;
    private move10Feet move220;

    public TableAuto(Drivebase subsystem) {
        this.turn90 = new Turn90(subsystem);
        this.move110 = new move10Feet(subsystem, 110);
        this.move220 = new move10Feet(subsystem, 220);

        addCommands(this.move110);
        addCommands(this.turn90);
        addCommands(this.move220);
    }
}