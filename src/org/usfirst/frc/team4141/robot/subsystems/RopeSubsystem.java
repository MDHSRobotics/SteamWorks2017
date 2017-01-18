package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;

public class RopeSubsystem extends MDSubsystem {
	
	public enum RopeSensor{
		up,
		down
	}

	public RopeSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	public static String motorName="ropeMotor";

	public MDSubsystem configure(){
		super.configure();

		if(getMotors()==null 
				|| !getMotors().containsKey(motorName))
			throw new IllegalArgumentException("Invalid motor configuration for rope system.");
		if(getSensors()==null 
				|| !getSensors().containsKey(RopeSensor.up.toString()) 
				|| !getSensors().containsKey(RopeSensor.down.toString()))
			throw new IllegalArgumentException("Invalid rope sensor configuration for gear system.");
		return this;
	}
	
	public void move(double speed){
		getMotors().get(motorName).setPosition(speed);
	}
	
	public boolean isUp(){
		return ((MDDigitalInput)(getSensors().get(RopeSensor.up.toString()))).get();
	}
	public boolean isDown(){
		return ((MDDigitalInput)(getSensors().get(RopeSensor.down.toString()))).get();
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