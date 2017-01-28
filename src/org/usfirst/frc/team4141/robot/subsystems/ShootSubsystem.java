
package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SolenoidPosition;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SwitchPosition;

public class ShootSubsystem extends MDSubsystem {
	
	

	public static String shootMotor="ShooterMotor";
	public static String angleMotor="AngleMotor";
		
		public MDSubsystem configure(){
			super.configure();
			//are we configured properly?
			// assume if more than one motor, use the first motor
			if(getMotors()==null 
					|| !getMotors().containsKey(shootMotor))
				throw new IllegalArgumentException("Invalid shooter motor configuration for shoot system.");
			if(getMotors()==null 
					|| !getMotors().containsKey(angleMotor))
				throw new IllegalArgumentException("Invalid angle motor configuration for shoot system.");
		
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

	public void shoot(double speed){
		getMotors().get(shootMotor).setPosition(speed);
	}
	public void move(double speed){
		getMotors().get(angleMotor).setPosition(speed);
	}

	public static boolean isOn() {
		// TODO Auto-generated method stub
		//may need to add code here
		return false;
	}

	public static void off() {
		// TODO Stop all shoot motors
		
	}
	
}
