package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.RopeSubsystem;

public class RopeLowerCommand extends MDCommand {
//speed subject to change
	private double speed=0.2;
	
	private RopeSubsystem ropeSubsystem;
	
	public RopeLowerCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("ropeSubsystem")){
			log(Level.ERROR, "initialize()", "rope subsystem not found");
		}
		else {
			ropeSubsystem = (RopeSubsystem)getRobot().getSubsystems().get("ropeSubsystem"); 
			ropeSubsystem.move(0);
		}
	}
	
	protected boolean isFinished() {
		return  ropeSubsystem.isUp();
	}
	
	protected void execute() {
		if (ropeSubsystem!=null)ropeSubsystem.move(speed);
	}
	@Override
		protected void end() {
			ropeSubsystem.move(0);
			
		}
}
