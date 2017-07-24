package org.usfirst.frc.team4141.MDRobotBase.sensors;

import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;

import edu.wpi.first.wpilibj.DriverStation;


public class FieldPositionSensor implements Sensor{
   
	StringSensorReading fieldSide;
	AnalogSensorReading driveStationPosition;
	private String name;
	private boolean observe;
	private MDSubsystem subsystem;


	public FieldPositionSensor(){
		this(null);
	}
	
	public FieldPositionSensor(MDSubsystem subsystem){
		this(null, true);
	}
	
	public FieldPositionSensor(MDSubsystem subsystem, boolean observe){
		this.observe = observe;
		this.subsystem = subsystem;
		fieldSide=new StringSensorReading(this,"fieldSide", "");
		driveStationPosition=new AnalogSensorReading(this,"station", 0);
	}

	public void setFieldSide(String side){
		fieldSide.setValue(side);
	}
	
	public String getFieldSide(){
		return fieldSide.getValue();
	}
	
	public void setDriveStationPosition(double pos){
		driveStationPosition.setValue(pos);
	}
	
	public double getDriveStationPosition(){
		return driveStationPosition.getValue();
	}
	
	public void setName(String name){
		this.name = name;
	}	

	public void refresh(){
		fieldSide.setValue(DriverStation.getInstance().getAlliance().toString());
		driveStationPosition.setValue(DriverStation.getInstance().getLocation());
	}

	@Override
	public String getName() {
		return name;
	}

	public SensorReading[] getReadings() {
		return new SensorReading[] {fieldSide,driveStationPosition};
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
