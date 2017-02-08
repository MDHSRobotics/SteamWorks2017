package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

public class StopShootSystemCommand extends MDCommand {

	public StopShootSystemCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("shootSubsystem")){
			log(Level.ERROR, "initialize()",  "Shoot Subsystem not found");
			throw new IllegalArgumentException("Shoot Subsystem not found");
		}
		shootSubsystem = (ShootSubsystem)getRobot().getSubsystems().get("shootSubsystem");
		requires(shootSubsystem);
	}
	
	private ShootSubsystem shootSubsystem;
	
	@Override
	protected void initialize() {
		
		}
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		shootSubsystem.stop();
	}
	
}
