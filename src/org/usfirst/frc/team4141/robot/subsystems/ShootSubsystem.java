package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.SpeedController;

public class ShootSubsystem extends MDSubsystem {
		
	//motors may change
	//private SpeedController shooterController;
	private SpeedController feederController;
	private double shootSpeed=1; 
	private double feedSpeed=1;
	private double unjamSpeed=-0.2;
	
	private double F=0.0;
	private double P=0.0;
	private double I=0.1;
	private double D=0.0;
	private double rpm=1.0;
	
	private CANTalon shooterController;

	
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
			shooterController = (CANTalon)(getMotors().get(shootMotor));
			feederController = (SpeedController)(getMotors().get(feedMotor));
			return this;
			
				
		}
		
	public ShootSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	
	}

	private double pidFactor = 0.005;
	
	@Override
	protected void setUp() {
		if(getConfigSettings().containsKey("shootSpeed")) shootSpeed = getConfigSettings().get("shootSpeed").getDouble();
		if(getConfigSettings().containsKey("feedSpeed")) feedSpeed = getConfigSettings().get("feedSpeed").getDouble();
		if(getConfigSettings().containsKey("unjamSpeed")) unjamSpeed = getConfigSettings().get("unjamSpeed").getDouble();
		if(getConfigSettings().containsKey("F")) F = getConfigSettings().get("F").getDouble();
		if(getConfigSettings().containsKey("P")) P = getConfigSettings().get("P").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("I")) I = getConfigSettings().get("I").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("D")) D = getConfigSettings().get("D").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("RPM")) rpm = getConfigSettings().get("RPM").getDouble();//*1000;
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		if(changedSetting.getName().equals("shootSpeed")) shootSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("feedSpeed")) feedSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("unjamSpeed")) unjamSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("F")) F = changedSetting.getDouble();
		if(changedSetting.getName().equals("P")) P = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("I")) I = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("D")) D = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("RPM")) rpm = changedSetting.getDouble();//*1000;
	
	}
	
	public void move(){
		//positive speed=wind
		//negative speed=unwind
    	double motorOutput = shooterController.getOutputVoltage() / shooterController.getBusVoltage();
    	double targetSpeed = shootSpeed * rpm; /* 1500 RPM in either direction */
    	shooterController.changeControlMode(TalonControlMode.Speed);
    	shooterController.set(targetSpeed);
    	/* prepare line to print */
//		System.out.println("\ttrg:" + targetSpeed);
//		System.out.print("\tspd:" + shooterController.getSpeed());
//		System.out.print("\terr:" + shooterController.getClosedLoopError());
//    	System.out.print("\tout:" + motorOutput);
	}
		
	public void initialize(){
		shooterController.enableControl();
		shooterController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterController.reverseSensor(false);
		shooterController.configEncoderCodesPerRev(400); // or 360

	        shooterController.configNominalOutputVoltage(+0.0f, -0.0f);
	        shooterController.configPeakOutputVoltage(+12.0f, -12.0f);
	        
	        shooterController.setProfile(0);
	        shooterController.setF(F);
	        shooterController.setP(P);
	        shooterController.setI(I); 
	        shooterController.setD(D);
		}

	@Override
	protected void initDefaultCommand() {

	}
	
	public void spin(){
//		shooterController.enableControl();
//		shooterController.set(shootSpeed);
//		debug("Spin at " + shootSpeed);
		move();
	}
	
	public void shoot(){
	feederController.set(feedSpeed);
	}
	
	public void unjam(){
		shooterController.set(unjamSpeed);
		feederController.set(unjamSpeed);
		
	}
	public void stop(){
		shooterController.disableControl();
		feederController.stopMotor();
	}

	public void stopFeed() {
		feederController.stopMotor();
	}
	
}

