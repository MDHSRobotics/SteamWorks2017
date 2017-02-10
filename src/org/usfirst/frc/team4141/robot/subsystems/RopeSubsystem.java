package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;

import edu.wpi.first.wpilibj.SpeedController;

public class RopeSubsystem extends MDSubsystem {
	
	private double speed=0.2;
	
	private SpeedController ropeController;
	
	public static String motorName="ropeMotor";

	public MDSubsystem configure(){
		super.configure();

		if(getMotors()==null 
				|| !getMotors().containsKey(motorName))
			throw new IllegalArgumentException("Invalid motor configuration for rope system.");
		ropeController = (SpeedController)(getMotors().get(motorName));
		return this;
	}
	
	public RopeSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	public void move(){
		//positive speed=wind
		//negative speed=unwind
		getMotors().get(motorName).setPosition(speed);
	}
		
	public void stop(){
		ropeController.stopMotor();
		
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
