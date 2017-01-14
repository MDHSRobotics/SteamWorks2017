package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.Logger.Level;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

public class MDStopCommand extends MDCommand {
	private MDDriveSubsystem driveSystem;


	public MDStopCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	private long start;
	private long duration = 15000;
	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("driveSystem")){
			log(Level.ERROR, "initialize()",  "drive system not found");
		}
		
		driveSystem = (MDDriveSubsystem)getRobot().getSubsystems().get("driveSystem"); 
		driveSystem.stop();
		start = (new Date()).getTime();
	}
	@Override
	protected boolean isFinished() {
		long now = (new Date()).getTime();
		return now>(start+duration);
	}
	
	@Override
	protected void execute() {
			driveSystem.stop();
	}

}
