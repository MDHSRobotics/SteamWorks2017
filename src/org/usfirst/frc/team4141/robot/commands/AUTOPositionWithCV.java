package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class AUTOPositionWithCV extends MDCommandGroup {
	public AUTOPositionWithCV(MDRobotBase robot){
		super(robot,"Auto4");
		addSequential(new MDPrintCommand(getRobot(),"auto4-1","[AUTO] Position w/CV: Begin"));
		addSequential(new MDPrintCommand(getRobot(),"auto4-2","CV Assisting?..."));
		addSequential(new MDPrintCommand(getRobot(),"auto4-3","Shooting?..."));
		addSequential(new MDPrintCommand(getRobot(),"auto4-4","Orientating..."));
		addSequential(new MDPrintCommand(getRobot(),"auto4-4","Moving..."));
		addSequential(new MDPrintCommand(getRobot(),"auto4-5","[AUTO] Position w/CV: End"));
	}
}
