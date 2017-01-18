package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.Logger.Level;
import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;
import org.usfirst.frc.team4141.robot.subsystems.RopeSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

public class RopeRiseCommand extends MDCommand {

	private double speed=0.2;
	
	private RopeSubsystem ropeSubsystem;
	
	public RopeRiseCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("ballSubsystem")){
			log(Level.ERROR, "initialize()", "ball subsystem not found");
		}
		ropeSubsystem = (RopeSubsystem)getRobot().getSubsystems().get("ropeSubsystem"); 
		ropeSubsystem.isUp();
	}
	
	protected boolean isFinished() {
		return  ropeSubsystem.isUp();
	}
	
	protected void execute() {
		ropeSubsystem.move(speed);
	}
}
