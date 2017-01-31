package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

// TODO: configure subsystem in Robot.java and configure buttons

public class BallPickupSubsystem extends MDSubsystem {

	public static String motorCollect="collectBallMotor";
	
	public MDSubsystem configure() {
		super.configure();
		if(getMotors()==null 
				|| !getMotors().containsKey(motorCollect))
			throw new IllegalArgumentException("Invalid motor configuration for ball Pickup system.");
		return this;
	}

	
	public BallPickupSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	}
	
	@Override
	protected void setUp() {
		
	}

	@Override
	public void settingChangeListener(ConfigSetting setting) {
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void collect(double position){
		getMotors().get(motorCollect).setPosition(position);
	}
	
	
	
}
