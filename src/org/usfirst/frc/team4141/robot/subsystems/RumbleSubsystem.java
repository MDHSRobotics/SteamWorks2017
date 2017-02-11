package org.usfirst.frc.team4141.robot.subsystems;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;


// TODO: configure subsystem in Robot.java and configure buttons

public class RumbleSubsystem extends MDSubsystem {
	private long rumbleDuration = 500;
	private double rumbleIntenisty = 0.5;
	
//	public MDSubsystem configure() {
//		super.configure();
//		if(getMotors()==null 
//				|| !getMotors().containsKey(motorCollect)  || !(getMotors().get(motorCollect) instanceof SpeedController))
//			throw new IllegalArgumentException("Invalid motor configuration for ball Pickup system.");
//		motorController = (SpeedController)(getMotors().get(motorCollect));
//		return this;
//	}
	
	public RumbleSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	}
	
	@Override
	protected void setUp() {
		if(getConfigSettings().containsKey("rumbleIntenisty")) rumbleIntenisty = getConfigSettings().get("rumbleIntenisty").getDouble();
		if(getConfigSettings().containsKey("rumbleDuration")) rumbleDuration = (long)(getConfigSettings().get("rumbleDuration").getDouble());
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		if(changedSetting.getName().equals("rumbleIntenisty")) rumbleIntenisty = changedSetting.getDouble();
		if(changedSetting.getName().equals("rumbleDuration")) rumbleDuration = (long)(changedSetting.getDouble());
	}

	@Override
	protected void initDefaultCommand() {	
	}
	
	public void rumble(){
		debug("rumbling...");
	}
	
	public double getRumbleDuration(){
		return  rumbleDuration;
	}

	public void stop() {
		debug("Stoped Rumbling");
		stop();
	}
	
	
}
