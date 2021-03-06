package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
//import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

public class ShootCommand extends MDCommand {
	
	public ShootCommand(MDRobotBase robot, String name) {
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
				return false;
			}
		@Override
		protected void execute() {
			shootSubsystem.shoot();
		}
		@Override
		protected void end() {
			shootSubsystem.stopFeed();
		}
		
	}

