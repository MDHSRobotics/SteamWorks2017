package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.RumbleSubsystem;

import edu.wpi.first.wpilibj.command.Scheduler;

public class RumbleCommand extends MDCommand {

	public RumbleCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("rumbleSubsystem")){
			log(Level.ERROR, "initialize()",  "Rumble Subsystem not found");
			throw new IllegalArgumentException("Rumble Subsystem not found");
		}
		rumbleSubsystem = (RumbleSubsystem)getRobot().getSubsystems().get("rumbleSubsystem");
		requires(rumbleSubsystem);
		
	}

	
	private RumbleSubsystem rumbleSubsystem;
	private long start;
	private long now;
	
	@Override
	protected void initialize() {
		start =(new Date()).getTime();
		rumbleSubsystem.rumble();
	}
	
	@Override
	protected boolean isFinished() {
		long now = (new Date()).getTime();
		return  (now >=(start+rumbleSubsystem.getRumbleDuration()));
	}
	
	@Override
	protected void execute() {
		rumbleSubsystem.rumble();
	}
	
	@Override
	protected void end() {
		rumbleSubsystem.stop();
	}
	
}