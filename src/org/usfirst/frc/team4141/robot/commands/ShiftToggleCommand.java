package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.eclipse.jetty.server.handler.DebugHandler;

//REMEMBER TO TEST CODE

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

import edu.wpi.first.wpilibj.command.Scheduler;

public class ShiftToggleCommand extends MDCommand {
	
	
	
	public ShiftToggleCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("driveSystem")){
			log(Level.ERROR, "initialize()",  "drive system not found");
		}
		driveSystem = (MDDriveSubsystem)getRobot().getSubsystems().get("driveSystem");
		
		requires(driveSystem);
		// TODO Auto-generated constructor stub
	}
	
	private MDDriveSubsystem driveSystem;
	private long start;
	private long shiftToogleDuration = 2000;
	private long now;

	
	@Override
	protected void initialize() {
		
		log(Level.DEBUG, "initialize()", "Shift Gears");
		
		start =(new Date()).getTime();
		driveSystem.shift();
	}
	
	@Override
	protected boolean isFinished() {
		long now = (new Date()).getTime();
		return  (now >=(start+shiftToogleDuration));
	}
	
	@Override
	protected void execute() {
		driveSystem.stop();
	}
	@Override
	protected void end() {
		driveSystem.stop();
		//TODO:  run collect command
		Scheduler.getInstance().add(new ArcadeDriveCommand(getRobot()));
	}

	
}
