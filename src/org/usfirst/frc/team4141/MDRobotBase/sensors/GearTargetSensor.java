package org.usfirst.frc.team4141.MDRobotBase.sensors;

import java.nio.ByteBuffer;

import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;

import edu.wpi.first.wpilibj.I2C;

public class GearTargetSensor implements Sensor{
   
	SensorReading[] readings = new SensorReading[1];
	private String name;
	private boolean observe;
	private MDSubsystem subsystem;


	public GearTargetSensor(){
		this(null);
	}
	
	public GearTargetSensor(MDSubsystem subsystem){
		this(null, true);
	}
	
	public GearTargetSensor(MDSubsystem subsystem, boolean observe){
		int i=0;
		readings[i++]=new DigitalSensorReading(this,"Gear Target", false);
	}

	public void set(boolean targetAcquried){
		((DigitalSensorReading)readings[0]).setValue(targetAcquried);
	}
	
	public boolean get(){
		return ((DigitalSensorReading)readings[0]).getValue();
	}
	
	public void setName(String name){
		this.name = name;
	}	

	public void refresh(){
	}

	@Override
	public String getName() {
		return name;
	}

	public SensorReading[] getReadings() {
		return readings;
	}


	@Override
	public boolean observe() {
		return observe;
	}
	public void setObserve(boolean observe){
		this.observe = observe;
	}

	@Override
	public MDSubsystem getSubsystem() {
		return subsystem;
	}
	@Override
	public Sensor setSubsystem(MDSubsystem subsystem) {
		this.subsystem = subsystem;
		return this;
	}
}
