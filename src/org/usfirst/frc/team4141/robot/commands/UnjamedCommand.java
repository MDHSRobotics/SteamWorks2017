package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;

import edu.wpi.first.wpilibj.command.Scheduler;

public class UnjamedCommand extends MDCommand {

	public UnjamedCommand(MDRobotBase robot, String name) {
		super(robot, name);
		
	}
	
	// TODO make this command require the ballpickup subsystem

	
	private BallPickupSubsystem ballPickupSubsystem;
	private long start;
	private long unjamedDuration = 2000;
	private long now;
	
	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("BallPickupSubsystem")){
			log(Level.ERROR, "initialize()",  "Ball Pickup Subsystem not found");
		}
		ballPickupSubsystem = (BallPickupSubsystem)getRobot().getSubsystems().get("BallPickupSubsystem");
		requires(ballPickupSubsystem);
		start =(new Date()).getTime();
		ballPickupSubsystem.stop();
	}
	@Override
	protected boolean isFinished() {
		long now = (new Date()).getTime();
		return  (now >=(start+unjamedDuration));
	}
	
	@Override
	protected void execute() {
		ballPickupSubsystem.unjam();
	}
	
	@Override
	protected void end() {
		ballPickupSubsystem.stop();
		//TODO:  run collect command
		Scheduler.getInstance().add(new CollectCommand(getRobot(), "CollectCommand"));
	}
	
}