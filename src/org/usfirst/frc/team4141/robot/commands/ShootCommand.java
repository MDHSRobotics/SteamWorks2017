package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

public class ShootCommand extends MDCommand {
	
	public ShootCommand(MDRobotBase robot, String name) {
		super(robot, name);
	}
		private ShootSubsystem shootSubsystem;
		
		@Override
		protected void initialize() {
			if(!getRobot().getSubsystems().containsKey("ShootSubsystem")){
				log(Level.ERROR, "initialize()",  "Shoot subsystem not found");
			}
			shootSubsystem = (ShootSubsystem)getRobot().getSubsystems().get("ShootSubsystem"); 
		}
		@Override
		protected boolean isFinished() {
				return true;
			}
		@Override
		protected void execute() {
			shootSubsystem.shoot();
		}
		
	}

