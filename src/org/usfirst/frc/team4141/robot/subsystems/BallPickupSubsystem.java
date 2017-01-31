package org.usfirst.frc.team4141.robot.subsystems;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

import edu.wpi.first.wpilibj.SpeedController;


// TODO: configure subsystem in Robot.java and configure buttons

public class BallPickupSubsystem extends MDSubsystem {

	public static String motorCollect="collectBallMotor";
	private double speed=0.5;
	private double unjamedSpeed=-0.3;
	private SpeedController motorController;
	
	public MDSubsystem configure() {
		super.configure();
		if(getMotors()==null 
				|| !getMotors().containsKey(motorCollect)  || !(getMotors().get(motorCollect) instanceof SpeedController))
			throw new IllegalArgumentException("Invalid motor configuration for ball Pickup system.");
		motorController = (SpeedController)(getMotors().get(motorCollect));
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
	
	public void collect(){
		motorController.set(speed);
	}
	
	public void stop(){
		motorController.stopMotor();
	}
	
	public void unjam(){
		motorController.set(unjamedSpeed);
	}
	
	
}
