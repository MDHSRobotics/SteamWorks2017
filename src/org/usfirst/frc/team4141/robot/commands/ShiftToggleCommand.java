package org.usfirst.frc.team4141.robot.commands;

//REMEMBER TO TEST CODE

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

public class ShiftToggleCommand extends MDCommand {
	
	
	public ShiftToggleCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

private MDDriveSubsystem driveSystem;
	
	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("driveSystem")){
			log(Level.ERROR, "initialize()",  "drive system not found");
		}
		driveSystem = (MDDriveSubsystem)getRobot().getSubsystems().get("driveSystem"); 
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		
			driveSystem.shift();
		
	}

	
}