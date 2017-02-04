package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

public class UnjamShootCommand extends MDCommand {
	
	private long start;
	private long now;
	private long unjamDuration = 2000;

	public UnjamShootCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
		if(!getRobot().getSubsystems().containsKey("ShootSubsystem")){
			log(Level.ERROR, "initialize()",  "Shoot subsystem not found");
		}
		shootSubsystem = (ShootSubsystem)getRobot().getSubsystems().get("ShootSubsystem"); 
		requires(shootSubsystem);
	}
		
private ShootSubsystem shootSubsystem;
		
		@Override
		protected void initialize() {
		}
		
		protected boolean isFinish() {
			long now = (new Date()).getTime();
			return  (now >=(start+unjamDuration));
		}
		
		@Override
		protected boolean isFinished() {
				return true;
			}
		@Override
		protected void execute() {
			shootSubsystem.unjam();
		}
		
	}

