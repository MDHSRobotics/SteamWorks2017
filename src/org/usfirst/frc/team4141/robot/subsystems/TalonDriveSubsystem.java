package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;

public class TalonDriveSubsystem extends MDSubsystem {
	
	private double talonSpeed=0.2;
	
	private CANTalon talonController;
	
	public static String motorName="talonMotor";

	public MDSubsystem configure(){
		super.configure();

		if(getMotors()==null 
				|| !getMotors().containsKey(motorName))
			throw new IllegalArgumentException("Invalid motor configuration for talon system.");
		talonController = (CANTalon)(getMotors().get(motorName));
		return this;
	}
	
	public TalonDriveSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	public void move(){
		//positive speed=wind
		//negative speed=unwind
		talonController.set(talonSpeed);
	}
		
	public void stop(){
		talonController.stopMotor();
		
	}
	
	@Override
	protected void setUp() {
		
		if(getConfigSettings().containsKey("talonSpeed")) talonSpeed = getConfigSettings().get("talonSpeed").getDouble();
		
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		
		if(changedSetting.getName().equals("talonSpeed")) talonSpeed = changedSetting.getDouble();

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
