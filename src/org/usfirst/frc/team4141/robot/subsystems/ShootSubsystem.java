package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import edu.wpi.first.wpilibj.SpeedController;

public class ShootSubsystem extends MDSubsystem {
		
	//motors may change
	private SpeedController shooterController;
	private SpeedController feederController;
	private double shootSpeed=1; 
	private double feedSpeed=1;
	private double unjamSpeed=-0.2;
	
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
			shooterController = (SpeedController)(getMotors().get(shootMotor));
			feederController = (SpeedController)(getMotors().get(feedMotor));
			return this;
			
				
		}
		
	public ShootSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	
	}

	@Override
	protected void setUp() {
		if(getConfigSettings().containsKey("shootSpeed")) shootSpeed = getConfigSettings().get("shootSpeed").getDouble();
		if(getConfigSettings().containsKey("feedSpeed")) feedSpeed = getConfigSettings().get("feedSpeed").getDouble();
		if(getConfigSettings().containsKey("unjamSpeed")) unjamSpeed = getConfigSettings().get("unjamSpeed").getDouble();
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		if(changedSetting.getName().equals("shootSpeed")) shootSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("feedSpeed")) feedSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("unjamSpeed")) unjamSpeed = changedSetting.getDouble();
	
	}

	@Override
	protected void initDefaultCommand() {

	}
	
	public void spin(){
		shooterController.set(shootSpeed);
//		debug("Spin at " + shootSpeed);
	}
	
	public void shoot(){
	feederController.set(feedSpeed);
	}
	
	public void unjam(){
		shooterController.set(unjamSpeed);
		feederController.set(unjamSpeed);
		
	}
	public void stop(){
		shooterController.stopMotor();
		feederController.stopMotor();
	}

	public void stopFeed() {
		feederController.stopMotor();
	}
	
}

