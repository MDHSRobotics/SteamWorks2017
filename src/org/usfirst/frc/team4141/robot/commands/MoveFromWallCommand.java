package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.AutonomousSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;

import edu.wpi.first.wpilibj.command.Scheduler;

public class MoveFromWallCommand extends MDCommand {

	private long start;
	private long now;
	private double autoSpeed;
	private long autoDuration;
	
	public MoveFromWallCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("autoSubsystem")) {
			log(Level.ERROR, "initialize()",  "Autonomous Subsystem not found");
			throw new IllegalArgumentException("Autonomous Subsystem not found");
		}
		if(!getRobot().getSubsystems().containsKey("driveSystem")) {
			log(Level.ERROR, "initialize()",  "Drive Subsystem not found");
			throw new IllegalArgumentException("Drive Subsystem not found");
		}
		autoSubsystem = (AutonomousSubsystem)getRobot().getSubsystems().get("autoSubsystem");
		requires(autoSubsystem);
		driveSubsystem = (MDDriveSubsystem)getRobot().getSubsystems().get("driveSystem");
		requires(driveSubsystem);
		
		// TODO Auto-generated constructor stub
	}

	private AutonomousSubsystem autoSubsystem;
	private MDDriveSubsystem driveSubsystem;
	
	@Override
	protected void initialize() {
		autoDuration = autoSubsystem.getAuto1Duration();
		autoSpeed = autoSubsystem.getAuto1Speed();
		start =(new Date()).getTime();	
		}
	
	@Override
	protected boolean isFinished() {
			long now = (new Date()).getTime();
			return  (now >=(start+autoDuration));
		}
	@Override
	protected void execute() {
		// TODO: Gyro implementation
		driveSubsystem.forward(autoSpeed);
		driveSubsystem.resetGyro();
	}
	
	@Override
	protected void end() {
		driveSubsystem.stop();
	}
	
}

