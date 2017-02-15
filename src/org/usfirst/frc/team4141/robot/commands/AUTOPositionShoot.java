package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class AUTOPositionShoot extends MDCommandGroup{
	public AUTOPositionShoot(MDRobotBase robot){
		super(robot,"Auto3");
		addSequential(new MDPrintCommand(getRobot(),"auto3-1","[AUTO] Position Shoot: Begin"));
		addSequential(new MDPrintCommand(getRobot(),"auto3-2","Moving..."));
		addSequential(new MDPrintCommand(getRobot(),"auto3-3","Orientating..."));
		addSequential(new MDPrintCommand(getRobot(),"auto3-4","Shooting..."));
		addSequential(new MDPrintCommand(getRobot(),"auto3-5","[AUTO] Position Shoot: End"));
	}

}


