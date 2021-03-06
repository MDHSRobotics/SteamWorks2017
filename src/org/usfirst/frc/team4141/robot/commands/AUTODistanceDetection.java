package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommandGroup;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class AUTODistanceDetection extends MDCommandGroup{
	public AUTODistanceDetection(MDRobotBase robot){
		super(robot,"Auto2");
		addSequential(new MDPrintCommand(getRobot(),"auto2-1","[AUTO] Detecting Distance: Begin"));
		addSequential(new MDPrintCommand(getRobot(),"auto2-2","Lidar... "));
		addSequential(new DistanceDetectionCommand(getRobot(),"It is moving..."));
		addSequential(new MDPrintCommand(getRobot(),"auto2-4","Gyro..."));
		addSequential(new MDPrintCommand(getRobot(),"auto2-5","[AUTO] Detecting Distance: End"));

	}

}


