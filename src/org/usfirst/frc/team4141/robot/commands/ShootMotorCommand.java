package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

public class ShootMotorCommand extends MDCommand {
	
	private double speed= 0.7;

	public ShootMotorCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
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
			if(ShootSubsystem.un()){ 
				ShootSubsystem.off();
				return true;
			}
			return false;
		}
		
		@Override
		protected void execute() {
			shootSubsystem.turn(speed);
		}
		
	}