package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SolenoidPosition;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SwitchPosition;

public class ShootSubsystem extends MDSubsystem {
	
	public enum Toggle{
		on,
		off
	}
	
	public static String motorName="turnShooterMotor";
	public static String motorName1="turnAgitatorMotor";
		
		public MDSubsystem configure(){
			super.configure();
			//are we configured properly?
			// assume if more than one motor, use the first motor
			if(getMotors()==null 
					|| !getMotors().containsKey(motorName))
				throw new IllegalArgumentException("Invalid shooter motor configuration for shoot system.");
			if(getMotors()==null 
					|| !getMotors().containsKey(motorName1))
				throw new IllegalArgumentException("Invalid agitator configuration for shoot system.");
			return this;

		}
		
	public ShootSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
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

	public void turn(double speed){
		getMotors().get(motorName).setPosition(speed);
	}
	public void low(double speed){
		getMotors().get(motorName1).setPosition(speed);
	}

	public static boolean on() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void off() {
		// TODO Auto-generated method stub
		
	}

	public static boolean un() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
