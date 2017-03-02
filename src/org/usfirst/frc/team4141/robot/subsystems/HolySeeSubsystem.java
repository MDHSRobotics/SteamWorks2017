package org.usfirst.frc.team4141.robot.subsystems;

import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.notifications.SwitchChannelNotification;

public class HolySeeSubsystem extends MDSubsystem{

	public HolySeeSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
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

}
