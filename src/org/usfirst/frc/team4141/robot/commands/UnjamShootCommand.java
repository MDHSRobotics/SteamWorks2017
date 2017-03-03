package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

import edu.wpi.first.wpilibj.command.Scheduler;

public class UnjamShootCommand extends MDCommand {
	
	private long start;
	private long unjamDuration = 2000;

	public UnjamShootCommand(MDRobotBase robot, String name) {
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
			start =(new Date()).getTime();
			shootSubsystem.stop();
		}
		
		protected boolean isFinished() {
			long now = (new Date()).getTime();
			return  (now >=(start+unjamDuration));
		}
		
		@Override
		protected void execute() {
			shootSubsystem.unjam();
		}
		protected void end() {
			shootSubsystem.stop();
			//TODO:  run collect command
			Scheduler.getInstance().add(new SpinShootMotorCommand(getRobot(), "SpinShootMotorCommand"));
		}
		
	}

