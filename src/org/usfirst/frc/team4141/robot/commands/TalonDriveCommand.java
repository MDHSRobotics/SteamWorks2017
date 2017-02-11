package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.RopeSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.TalonDriveSubsystem;

public class TalonDriveCommand extends MDCommand {
	
	private TalonDriveSubsystem talonSubsystem;
	
	public TalonDriveCommand(MDRobotBase robot, String name) {
		super(robot, name);
		if(!getRobot().getSubsystems().containsKey("talonSubsystem")){
			log(Level.ERROR, "initialize()", "talon subsystem not found");
			throw new IllegalArgumentException("Talon Subsystem not found");
		}
		talonSubsystem = (TalonDriveSubsystem)getRobot().getSubsystems().get("talonSubsystem"); 
		requires(talonSubsystem);
	}

	protected void initialize() {
		}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void execute() {
		if (talonSubsystem!=null)talonSubsystem.move();
	}
	
	@Override
		protected void end() {
			
		talonSubsystem.stop();
			
		}
}
