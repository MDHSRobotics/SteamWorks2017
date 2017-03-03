package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.notifications.SwitchChannelNotification;
import org.usfirst.frc.team4141.MDRobotBase.sensors.GearTargetSensor;
import org.usfirst.frc.team4141.MDRobotBase.sensors.SteamTargetSensor;
import org.usfirst.frc.team4141.MDRobotBase.sensors.VisionConnectedSensor;


public class HolySeeSubsystem extends MDSubsystem{

	private VisionConnectedSensor visionConnected;
	private SteamTargetSensor steamTargetAcquired;
	private GearTargetSensor gearTargetAcquired;

	public HolySeeSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
	}
	public MDSubsystem configure(){
		super.configure();

		if(getSensors()==null || !getSensors().containsKey("visionConnected"))
			throw new IllegalArgumentException("Invalid HolySeeSubsystem configuration, missing VisionConnectedSensor.");
		visionConnected = (VisionConnectedSensor)(getSensors().get("visionConnected"));
		if(getSensors()==null || !getSensors().containsKey("Steam Target Acquired"))
			throw new IllegalArgumentException("Invalid HolySeeSubsystem configuration, missing SteamTargetSensor.");
		steamTargetAcquired = (SteamTargetSensor)(getSensors().get("Steam Target Acquired"));
		if(getSensors()==null || !getSensors().containsKey("Gear Target Acquired"))
			throw new IllegalArgumentException("Invalid HolySeeSubsystem configuration, missing GearTargetSensor.");
		gearTargetAcquired = (GearTargetSensor)(getSensors().get("Gear Target Acquired"));
		return this;
	}
	@Override
	protected void initDefaultCommand() {
	}

	@Override
	protected void setUp() {
	}

	@Override
	public void settingChangeListener(ConfigSetting setting) {
	}

	public void switchChannel() {
		debug("switching channel\n");
		getRobot().post(new SwitchChannelNotification(getRobot()));
	}

	public boolean getVisionConnected(){
		return visionConnected.get();
	}
	
	public boolean getSteamTargetAcquired(){
		return steamTargetAcquired.get();
	}
	
	public boolean getGearTargetAcquired(){
		return gearTargetAcquired.get();
	}	

	public void setVisionConnected(boolean connected){
		visionConnected.set(connected);
	}
	public void setSteamTargetAcquired(boolean targetAcquired){
		steamTargetAcquired.set(targetAcquired);
	}
	public void setGearTargetAcquired(boolean targetAcquired){
		gearTargetAcquired.set(targetAcquired);
	}
	
}
