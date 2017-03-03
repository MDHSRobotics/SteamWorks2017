package org.usfirst.frc.team4141.MDRobotBase.sensors;

import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;

public class ConsoleConnectionSensor implements Sensor{
   
	SensorReading[] readings = new SensorReading[1];
	private String name;
	private boolean observe;
	private MDSubsystem subsystem;


	public ConsoleConnectionSensor(){
		this(null);
	}
	
	public ConsoleConnectionSensor(MDSubsystem subsystem){
		this(null, true);
	}
	
	public ConsoleConnectionSensor(MDSubsystem subsystem, boolean observe){
		this.observe = observe;
		this.subsystem = subsystem;
		int i=0;
		reading=new StringSensorReading(this,"console", "");
	}

	public void set(String consoleAddress){
		readings.setValue(consoleAddress);
	}
	
	public String get(){
		return reading.getValue();
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
