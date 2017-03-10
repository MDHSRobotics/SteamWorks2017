package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

import edu.wpi.first.wpilibj.SpeedController;


// TODO: configure subsystem in Robot.java and configure buttons

public class BallPickupSubsystem extends MDSubsystem {

	public static String motorCollect="collectBallMotor";
	private double pickupSpeed=0.5;
	private double unjamedSpeed=-0.3;
	private SpeedController motorController;
	
	public MDSubsystem configure() {
		super.configure();
		if(getMotors()==null 
				|| !getMotors().containsKey(motorCollect)  || !(getMotors().get(motorCollect) instanceof SpeedController))
			throw new IllegalArgumentException("Invalid motor configuration for ball Pickup system.");
		motorController = (SpeedController)(getMotors().get(motorCollect));
		setCore(true);

		return this;
	}

	
	public BallPickupSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	}
	
	@Override
	protected void setUp() {
		if(getConfigSettings().containsKey("pickupSpeed")) pickupSpeed = getConfigSettings().get("pickupSpeed").getDouble();
		if(getConfigSettings().containsKey("unjamSpeed")) unjamedSpeed = getConfigSettings().get("unjamSpeed").getDouble();
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		if(changedSetting.getName().equals("pickupSpeed")) pickupSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("unjamSpeed")) unjamedSpeed = changedSetting.getDouble();
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void collect(){
		motorController.set(pickupSpeed);
	}
	
	public void stop(){
		motorController.stopMotor();
	}
	
	public void unjam(){
		motorController.set(unjamedSpeed);
	}
	
	
}
