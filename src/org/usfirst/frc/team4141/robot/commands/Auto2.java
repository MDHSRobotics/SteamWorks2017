package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class Auto2 extends MDCommandGroup{
	public Auto2(MDRobotBase robot){
		super(robot,"Auto2");
		addSequential(new MDPrintCommand(getRobot(),"auto2-1","auto2-1"));
		addSequential(new MDPrintCommand(getRobot(),"auto2-2","auto2-2"));
		addSequential(new MDPrintCommand(getRobot(),"auto2-3","auto2-3"));
	}

}


