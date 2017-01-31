//package org.usfirst.frc.team4141.robot.commands;
//
//import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
//import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
//import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
//
//import java.util.Date;
//
//import org.usfirst.frc.team4141.robot.subsystems.BallPickupSubsystem;
//
//public class CloseDoorCommand extends MDCommand {
//
//	public CloseDoorCommand(MDRobotBase robot, String name) {
//		super(robot, name);
//		// TODO Auto-generated constructor stub
//	}
//
//	private BallPickupSubsystem ballSubsystem;
//	private long start;
//	private long duration=5000;
//	
//	@Override
//	protected void initialize() {
//		if(!getRobot().getSubsystems().containsKey("gearSubsystem")){
//			log(Level.ERROR, "initialize()",  "ball subsystem not found");
//		}
//		ballSubsystem = (BallPickupSubsystem)getRobot().getSubsystems().get("ballSubsystem");
//		start=(new Date()).getTime();
//	}
//	
//	@Override
//	protected boolean isFinished() {
//		long end=(new Date()).getTime();
//		return start + duration < end;
//	}
//	
//	@Override
//	protected void execute() {
//		ballSubsystem.move(BallPickupSubsystem.closePosition);
//	}
//	
//}
