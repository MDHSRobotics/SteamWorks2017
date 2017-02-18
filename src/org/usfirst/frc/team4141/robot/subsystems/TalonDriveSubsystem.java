package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class TalonDriveSubsystem extends MDSubsystem {
	
	private double talonSpeed=0.2;
	private double F=0.11;
	private double P=0.22;
	private double I=0.0;
	private double D=0.0;
	private double rpm=1.0;
	
	
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
		
	}
	
	public void move(){
		//positive speed=wind
		//negative speed=unwind
//		talonController.set(talonSpeed);
		double targetSpeed = talonSpeed * rpm; /* 1500 RPM in either direction */
    	talonController.set(targetSpeed);
	}
		
	public void initialize(){
		talonController.enableControl();
	       talonController.configNominalOutputVoltage(+0.0f, -0.0f);
	       talonController.configPeakOutputVoltage(+12.0f, -12.0f);
	        /* set closed loop gains in slot0 */
	       talonController.setProfile(0);
	        talonController.setF(F);
	        talonController.setP(P);
	        talonController.setI(I); 
	        talonController.setD(D);
	        talonController.changeControlMode(TalonControlMode.Speed);
		}
	
	public void stop(){
		talonController.disableControl();
		
	}
	
	@Override
	protected void setUp() {
		
		if(getConfigSettings().containsKey("talonSpeed")) talonSpeed = getConfigSettings().get("talonSpeed").getDouble();
		if(getConfigSettings().containsKey("F")) F = getConfigSettings().get("F").getDouble();
		if(getConfigSettings().containsKey("P")) P = getConfigSettings().get("P").getDouble();
		if(getConfigSettings().containsKey("I")) I = getConfigSettings().get("I").getDouble();
		if(getConfigSettings().containsKey("D")) D = getConfigSettings().get("D").getDouble();
		if(getConfigSettings().containsKey("RPM")) rpm = getConfigSettings().get("RPM").getDouble();//*1000;
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		
		if(changedSetting.getName().equals("talonSpeed")) talonSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("F")) F = changedSetting.getDouble();
		if(changedSetting.getName().equals("P")) P = changedSetting.getDouble();
		if(changedSetting.getName().equals("I")) I = changedSetting.getDouble();
		if(changedSetting.getName().equals("D")) D = changedSetting.getDouble();
		if(changedSetting.getName().equals("RPM")) rpm = changedSetting.getDouble();//*1000;

	}

	@Override
	protected void initDefaultCommand() {

	}

}
