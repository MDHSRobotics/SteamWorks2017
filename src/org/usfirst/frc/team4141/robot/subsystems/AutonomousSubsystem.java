package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;

public class AutonomousSubsystem extends MDSubsystem {

	private double auto1Speed;
	private long auto1Duration;
	
	public AutonomousSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub
		if(getConfigSettings().containsKey("auto1Speed")) auto1Speed = getConfigSettings().get("auto1Speed").getDouble();
		if(getConfigSettings().containsKey("auto1Duration")) auto1Duration = (long) (getConfigSettings().get("auto1Duration").getDouble()*1000);


	}

	@Override
	public void settingChangeListener(ConfigSetting changedSetting) {
		// TODO Auto-generated method stub
		if(changedSetting.getName().equals("auto1Speed")) auto1Speed = changedSetting.getDouble();
		if(changedSetting.getName().equals("auto1Duration")) auto1Duration = (long) (changedSetting.getDouble()*1000);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public long getAuto1Duration() {
		return auto1Duration;
	}
	
	public double getAuto1Speed() {
		return auto1Speed;
	}

}
