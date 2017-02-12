package org.usfirst.frc.team4141.MDRobotBase;

import org.usfirst.frc.team4141.robot.commands.MDPrintCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class MDCommandGroup extends MDCommand {
	
	private CommandGroup group;

	public MDCommandGroup(MDRobotBase robot, String name) {
		super(robot,name);
		group = new CommandGroup();
	}
	

	protected void addSequential(Command command) {
		if(group!=null) group.addSequential(command);	
	}
	protected void addSequential(Command command, double timeOut) {
		if(group!=null) group.addSequential(command,timeOut);	
	}
	protected void addParallel(Command command) {
		if(group!=null) group.addParallel(command);	
	}
	protected void addParallel(Command command, double timeOut) {
		if(group!=null) group.addParallel(command,timeOut);	
	}
	public void cancel() {
		if(group!=null) group.cancel();;	
	}

}
