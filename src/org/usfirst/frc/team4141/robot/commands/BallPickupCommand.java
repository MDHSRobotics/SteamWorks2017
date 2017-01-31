package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;

public class BallPickupCommand extends MDCommand {

	public BallPickupCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

	private double speed= 0.7;
	
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
				return false;
			}
			
			@Override
			protected void execute() {
				ballPickupSubsystem.collect(speed);
			}
			
			
		}
