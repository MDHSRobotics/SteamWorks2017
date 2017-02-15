package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class AUTOGearPlacement extends MDCommandGroup {
	public AUTOGearPlacement(MDRobotBase robot){
		super(robot,"Auto5");
		addSequential(new MDPrintCommand(getRobot(),"auto5-1","[AUTO] Detecting Distance: Begin"));
		addSequential(new MDPrintCommand(getRobot(),"auto5-2","Gyro..."));
		addSequential(new MDPrintCommand(getRobot(),"auto5-3","Lidar..."));
		addSequential(new MDPrintCommand(getRobot(),"auto5-4","Turn..."));
		addSequential(new MDPrintCommand(getRobot(),"auto5-5","Clear..."));
		addSequential(new MDPrintCommand(getRobot(),"auto5-6","[AUTO] Detecting Distance: End"));

	}
}
