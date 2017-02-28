package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.FeedbackDeviceStatus;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon.VelocityMeasurementPeriod;

public class TalonDriveSubsystem extends MDSubsystem {


	
	private double talonSpeed=0.2;
	private double F=0.0;
	private double P=0.0;
	private double I=0.1;
	private double D=0.0;
	private double rpm=1.0;
	private int motorOutput;
	private double targetSpeed;


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
//      double targetSpeed = talonSpeed * rpm; /* 1500 RPM in either direction */
//	    talonController.changeControlMode(TalonControlMode.Speed);
//    	talonController.set(targetSpeed);
//		talonController.changeControlMode(TalonControlMode.PercentVbus);
//		talonController.set(talonSpeed);
    	double motorOutput = talonController.getOutputVoltage() / talonController.getBusVoltage();
    	double targetSpeed = talonSpeed * rpm; /* 1500 RPM in either direction */
    	talonController.changeControlMode(TalonControlMode.Speed);
    	talonController.set(targetSpeed);
    	/* prepare line to print */
    	System.out.print("\tout:" + motorOutput);
		System.out.print("\tspd:" + talonController.getSpeed());
		System.out.print("\terr:" + talonController.getClosedLoopError());
		System.out.println("\ttrg:" + targetSpeed);
//		double currentAmps = _talons[masterId].getOutputCurrent(); 
//		double outputV = _talons[masterId].getOutputVoltage();
//		double busV = _talons[masterId].getBusVoltage();
//		double quadEncoderPos = _talons[masterId].getEncPosition(); 
//		double quadEncoderVelocity = _talons[master1d].getEchelocity(); 
//		int analogPos = _talons[masterId].getAnalogInPosition();
//		int analogVelocity = _talons[masterId].getAnalogInVelocity(); 
//		double selectedSensorPos = _talons[masterId].getPosition(); 
//		double selectedSensorSpeed = _talons[master1d].getSpeed();
//		int closeLoopErr = _talons[masterId].getClosedLoopError();
	}
		
	public void initialize(){
		talonController.enableControl();
		talonController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talonController.reverseSensor(false);
		talonController.configEncoderCodesPerRev(400); // or 360 or 400
//		talonController.SetVelocityMeasurementPeriod(VelocityMeasurementPeriod.Period_100Ms);
//		talonController.SetVelocityMeasurementWindow(64);
	        //_talon.configEncoderCodesPerRev(XXX), // if using FeedbackDevice.QuadEncoder
	        //_talon.configPotentiometerTurns(XXX), // if using FeedbackDevice.AnalogEncoder or AnalogPot
	        talonController.configNominalOutputVoltage(+0.0f, -0.0f);
	        talonController.configPeakOutputVoltage(+12.0f, -12.0f);
	        /* set closed loop gains in slot0 */
	        //end
	        talonController.setProfile(0);
	        talonController.setF(F);
	        talonController.setP(P);
	        talonController.setI(I); 
	        talonController.setD(D);
//	        talonController.setProfile(0);
	        
//	        talonController.changeControlMode(TalonControlMode.PercentVbus);
//			talonController.set(talonSpeed);
	 
//	        double targetSpeed = talonSpeed * rpm; /* 1500 RPM in either direction */
//		    talonController.changeControlMode(TalonControlMode.Speed);
//	    	talonController.set(targetSpeed);
	    	
//	    	double motorOutput = talonController.getOutputVoltage() / talonController.getBusVoltage();
//		    System.out.print("\tout:");
//			System.out.print(motorOutput);
//			System.out.print("\tspd:");
//			System.out.print(talonController.getSpeed() );
//			System.out.print("\terr:");
//			System.out.print(talonController.getClosedLoopError());
//			System.out.print("\ttrg:");
//			System.out.print(targetSpeed);
//			System.out.println(talonSpeed);
	        
		}
	
	public void stop(){
		talonController.disableControl();
		
	}
	
	private double pidFactor = 0.005;
	@Override
	protected void setUp() {
		if(getConfigSettings().containsKey("talonSpeed")) talonSpeed = getConfigSettings().get("talonSpeed").getDouble();
		if(getConfigSettings().containsKey("F")) F = getConfigSettings().get("F").getDouble();
		if(getConfigSettings().containsKey("P")) P = getConfigSettings().get("P").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("I")) I = getConfigSettings().get("I").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("D")) D = getConfigSettings().get("D").getDouble()*pidFactor;
		if(getConfigSettings().containsKey("RPM")) rpm = getConfigSettings().get("RPM").getDouble();//*1000;
	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		
		if(changedSetting.getName().equals("talonSpeed")) talonSpeed = changedSetting.getDouble();
		if(changedSetting.getName().equals("F")) F = changedSetting.getDouble();
		if(changedSetting.getName().equals("P")) P = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("I")) I = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("D")) D = changedSetting.getDouble()*pidFactor;
		if(changedSetting.getName().equals("RPM")) rpm = changedSetting.getDouble();//*1000;

	}

	@Override
	protected void initDefaultCommand() {

	}


}
