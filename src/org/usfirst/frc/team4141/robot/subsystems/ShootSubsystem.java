
package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SolenoidPosition;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SwitchPosition;

import edu.wpi.first.wpilibj.Solenoid;

public class ShootSubsystem extends MDSubsystem {
	
	public enum positionSolenoid{
		first
	}
		
	public enum DeflectingSolenoid{
		open,
		closed
	}

	public static String shootMotor="ShooterMotor";
	public static String angleMotor="AngleMotor";
	public static String deflectorSolenoid="DeflectorSolenoid";
		
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
			if(getSolenoids()==null 
					|| !getSolenoids().containsKey(positionSolenoid.first.toString()))
				throw new IllegalArgumentException("Invalid solenoid configuration for shoot system.");
			if(getSolenoids()==null 
					|| !getSolenoids().containsKey(DeflectingSolenoid.open.toString())
				    || !getSolenoids().containsKey(DeflectingSolenoid.closed.toString())) 
				throw new IllegalArgumentException("Invalid solenoid configuration for shoot system.");
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
	
	public void open(){
		Solenoid deflectorSolenoid = (Solenoid)getSolenoids().get(DeflectingSolenoid.open);
		deflectorSolenoid.set(true);
	}
	public void close(){
		Solenoid deflectorSolenoid = (Solenoid)getSolenoids().get(DeflectingSolenoid.closed);
		deflectorSolenoid.set(false);
	}
		
	public boolean recessed(){
		return ((MDDigitalInput)(getSensors().get(SwitchPosition.recessed.toString()))).get();
	}
	public boolean extended(){
		return ((MDDigitalInput)(getSensors().get(SwitchPosition.extended.toString()))).get();
	}
	
	public static void off() {
		// TODO Stop all shoot motors
		
	}
	
}
