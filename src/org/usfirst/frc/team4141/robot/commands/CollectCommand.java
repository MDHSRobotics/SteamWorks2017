package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;

public class CollectCommand extends MDCommand {

	public CollectCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("ballPickupSubsystem")){
			log(Level.ERROR, "initialize()",  "Ball Pickup Subsystem not found");
			throw new IllegalArgumentException("Ball Pickup Subsystem not found");
		}
		ballPickupSubsystem = (BallPickupSubsystem)getRobot().getSubsystems().get("ballPickupSubsystem");
		requires(ballPickupSubsystem);
	}
	
	private BallPickupSubsystem ballPickupSubsystem;
	
	@Override
	protected void initialize() {
		
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void execute() {
		ballPickupSubsystem.collect();
	}
	
}
