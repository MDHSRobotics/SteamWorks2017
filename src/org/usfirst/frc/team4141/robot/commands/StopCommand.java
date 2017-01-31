package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;

public class StopCommand extends MDCommand {

	public StopCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO make this command require the ballpickup subsystem
	}
	
	private BallPickupSubsystem ballPickupSubsystem;
	
	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("BallPickupSubsystem")){
			log(Level.ERROR, "initialize()",  "Ball Pickup Subsystem not found");
		}
		ballPickupSubsystem = (BallPickupSubsystem)getRobot().getSubsystems().get("BallPickupSubsystem");
	}
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		ballPickupSubsystem.stop();
	}
	
}
