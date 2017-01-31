package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

public class ToggleOrientationCommand extends MDCommand {

	public ToggleOrientationCommand(MDRobotBase robot, String name) {
		super(robot, name);
		
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
		
			driveSystem.flip();
		
	}

}
