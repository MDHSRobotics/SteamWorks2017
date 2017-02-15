package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class Auto1 extends MDCommandGroup{
	public Auto1(MDRobotBase robot){
		super(robot,"Auto1");
		addSequential(new MDPrintCommand(getRobot(),"auto1-1","Scenario - Auto1: BEGIN!!"));
		addSequential(new MoveFromWallCommand(getRobot(),"Move From Wall."));
		addSequential(new MDPrintCommand(getRobot(),"auto1-3","Scenario - Auto1: End... :("));
	}

}


