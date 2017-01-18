package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

// TODO: configure subsystem in Robot.java and configure buttons

public class BallSubsystem extends MDSubsystem {

	public static int closePosition=0;
	public static int openPosition=140;
	
	public static String motorName="gateServoMotor";
	
	public MDSubsystem configure() {
		super.configure();
		if(getMotors()==null 
				|| !getMotors().containsKey(motorName))
			throw new IllegalArgumentException("Invalid motor configuration for ball system.");
		return this;
	}

	
	public BallSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	}
	
	public void move(double position){
		getMotors().get(motorName).setPosition(position);
	}
	
	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void settingChangeListener(ConfigSetting setting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
