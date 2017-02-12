package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class Auto1 extends MDCommandGroup{
	public Auto1(MDRobotBase robot,String name){
		super(robot,name);
		addSequential(new MDPrintCommand(getRobot(),"auto1-1","auto1-1"));
		addSequential(new MDPrintCommand(getRobot(),"auto1-2","auto1-2"));
		addSequential(new MDPrintCommand(getRobot(),"auto1-3","auto1-3"));
	}

}


