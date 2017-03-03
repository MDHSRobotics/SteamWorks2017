package org.usfirst.frc.team4141.MDRobotBase.sensors;

import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;

public class SteamTargetSensor implements Sensor{
   
	SensorReading[] readings = new SensorReading[1];
	private String name;
	private boolean observe;
	private MDSubsystem subsystem;


	public SteamTargetSensor(){
		this(null);
	}
	
	public SteamTargetSensor(MDSubsystem subsystem){
		this(null, true);
	}
	
	public SteamTargetSensor(MDSubsystem subsystem, boolean observe){
		this.observe = observe;
		this.subsystem = subsystem;
		int i=0;
		readings[i++]=new DigitalSensorReading(this,"Steam Target", false);
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