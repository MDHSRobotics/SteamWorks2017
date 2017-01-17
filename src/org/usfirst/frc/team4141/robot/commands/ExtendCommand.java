package org.usfirst.frc.team4141.robot.commands;


import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.LogNotification.Level;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;

public class ExtendCommand extends MDCommand {

	private double speed=0.4;
	
	public ExtendCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}

	private GearSubSystem gearSubsystem;
	

	@Override
	protected void initialize() {
		if(!getRobot().getSubsystems().containsKey("gearSubsystem")){
			log(Level.ERROR, "initialize()",  "gear subsystem not found");
		}
		gearSubsystem = (GearSubSystem)getRobot().getSubsystems().get("gearSubsystem"); 
		gearSubsystem.open();
	}
	
	@Override
	protected boolean isFinished() {
		return  gearSubsystem.isExtended();
	}
	
	@Override
	protected void execute() {
		gearSubsystem.move(speed);
	}
	
}
