package org.usfirst.frc.team4141.robot.commands;

import java.util.Date;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.robot.subsystems.AutonomousSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;

public class DistanceDetectionCommand extends MDCommand {
	
	private double auto2Distance;
	private double targetDistance = 10;
	private double autoSpeed;

	public DistanceDetectionCommand(MDRobotBase robot, String name) {
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
	}
	
	private AutonomousSubsystem autoSubsystem;
	private MDDriveSubsystem driveSubsystem;
		
	@Override
	protected void initialize() {
		auto2Distance = autoSubsystem.getAuto2Distance();
		autoSpeed = autoSubsystem.getAuto1Speed();
		}
	
	@Override
	protected boolean isFinished() {
		return (auto2Distance >= targetDistance);
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
