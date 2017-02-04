package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SolenoidPosition;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SwitchPosition;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class ShootSubsystem extends MDSubsystem {
		
	private SpeedController shooterController;
	private SpeedController feederController;
	private double shootspeed=0.5; 
	private double feedspeed=0.5;
	private double unjamspeed=-0.2;
	
	public static String shootMotor="ShootMotor";
	public static String feedMotor="FeedMotor";
	
		public MDSubsystem configure(){
			super.configure();
			//are we configured properly?
			// assume if more than one motor, use the first motor
			if(getMotors()==null 
					|| !getMotors().containsKey(shootMotor))
				throw new IllegalArgumentException("Invalid shooter motor configuration for shoot system.");
			if(getMotors()==null 
					|| !getMotors().containsKey(feedMotor))
				throw new IllegalArgumentException("Invalid feeder motor configuration for shoot system.");
			return this;
				
		}
		
	public ShootSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	
	}

	@Override
	protected void setUp() {

	}

	@Override
	public void settingChangeListener(ConfigSetting setting) {
		// TODO: add a shooting setting for UI
	}

	@Override
	protected void initDefaultCommand() {

	}
	
	public void spin(){
		shooterController.set(shootspeed);
	}
	
	public void shoot(){
	feederController.set(feedspeed);
	}
	
	public void unjam(){
		shooterController.set(unjamspeed);
		feederController.set(unjamspeed);
	}
	public void stop(){
		shooterController.stopMotor();
		feederController.stopMotor();
	}
	
}

