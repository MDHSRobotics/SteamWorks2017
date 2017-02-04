package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;

public class CollectCommand extends MDCommand {

	public CollectCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	private BallPickupSubsystem ballPickupSubsystem;
	
	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("BallPickupSubsystem")){
			log(Level.ERROR, "initialize()",  "Ball Pickup Subsystem not found");
		}
		ballPickupSubsystem = (BallPickupSubsystem)getRobot().getSubsystems().get("BallPickupSubsystem");
		requires(ballPickupSubsystem);
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