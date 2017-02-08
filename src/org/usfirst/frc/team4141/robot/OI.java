package org.usfirst.frc.team4141.robot;


import org.usfirst.frc.team4141.MDRobotBase.ConsoleOI;
import org.usfirst.frc.team4141.MDRobotBase.MDJoystick;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.OIBase;
import org.usfirst.frc.team4141.MDRobotBase.RioHID;
import org.usfirst.frc.team4141.robot.commands.CollectCommand;
import org.usfirst.frc.team4141.robot.commands.MDMoveCommand;
import org.usfirst.frc.team4141.robot.commands.MDMoveCommand.Direction;
import org.usfirst.frc.team4141.robot.commands.MDPrintCommand;
//import org.usfirst.frc.team4141.robot.commands.OpenDoorCommand;
import org.usfirst.frc.team4141.robot.commands.RopeRiseCommand;

import org.usfirst.frc.team4141.robot.commands.StopBallsystemCommand;
import org.usfirst.frc.team4141.robot.commands.StopShootSystemCommand;
import org.usfirst.frc.team4141.robot.commands.ShiftToggleCommand;
import org.usfirst.frc.team4141.robot.commands.ShootCommand;
//import org.usfirst.frc.team4141.robot.commands.ShootCommand;
import org.usfirst.frc.team4141.robot.commands.ToggleOrientationCommand;
import org.usfirst.frc.team4141.robot.commands.UnjamBallsystemCommand;
import org.usfirst.frc.team4141.robot.commands.UnjamShootCommand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends OIBase{
	
	public OI(MDRobotBase robot) {
		super(robot);
		robot.debug("OI created");
	}


	public void configureOI(){
		//A robot should have 1 or more operator interfaces (OI)
		//Typically, a robot will have at least 1 joystick and 1 console
		
		//if using gamepad, the buttons are generally as follows:
		// a is button 1
		// b is button 2
		// x is button 3
		// y is button 4
		
//		if using joystick, the buttons are generally as follows:
//			trigger is button 1
//			side is button 2
//			3 is button 3
//			4 is button 4
//			5 is button 5
//			6 is button 6
		
		
		
//      Configure the joystick(s) here
		add(new MDJoystick(getRobot(), "driveJoystick", 0)
//			.whenPressed("rightBumper",5,new MDPrintCommand(getRobot(),"Right Bumper Command","Right Bumper Command message"))
//			.whileHeld("leftBumper",6,new MDPrintCommand(getRobot(),"Left Bumper Command","Left Bumper Command message"))
//          the following commands are test move commands useful in testing drive configuration and set up
//          comment out and replace as needed
				
/*
			// Controller Config: Xbox
			
			.whenPressed("X",3,new MDMoveCommand(getRobot(),"left command",Direction.left))
			.whenPressed("A",1,new MDMoveCommand(getRobot(),"reverse command",Direction.reverse))
			.whenPressed("B",2,new OpenDoorCommand(getRobot(),"Open Door Command"))
			.whenPressed("B",2,new MDMoveCommand(getRobot(),"right command",Direction.right))
			.whenPressed("A",1,new MDMoveCommand(getRobot(),"forward command",Direction.forward))
			.whenPressed("LeftBumper",5,new ExtendCommand(getRobot(),"ExtendCommand"))
			.whenPressed("RightBumper",6,new RetractCommand(getRobot(),"RetractCommand"))
			.whenPressed("LeftBumper",5,new MDPrintCommand(getRobot(),"LB","Left Bumper Pressed"))
			.whenPressed("RightBumper",6,new MDPrintCommand(getRobot(),"RB","Right Bumper Pressed"))
			.whenPressed("RightBumper",6,new MDPrintCommand(getRobot(),"RB","Right Bumper Pressed"))
			.whenPressed("Y",4,new ToggleOrientationCommand(getRobot(),"Flip"))
*/
				
			// Joystick Config: EXTREME 360 Pro

				
//			.whenPressed("trigger",1,new StopBallsystemCommand(getRobot(), "StopBallsystemCommand"))
			.whenPressed("SideButton",2,new ToggleOrientationCommand(getRobot(), "ToggleOrientationCommand"))
//			.whenPressed("Button7",7,new StopBallsystemCommand(getRobot(), "CollectCommand"))
	

			.whileHeld("trigger",1,new ShootCommand(getRobot(), "ShootCommand"))
//			.whenPressed("Trigger",1,new ShootCommand(getRobot(), "ShootCommand"))
//			.whenPressed("SideButton",2,new ToggleOrientationCommand(getRobot(), "ToggleOrientationCommand"))
//			.whenPressed("Button3",3,new OpenDoorCommand(getRobot(), "OpenDoorCommand"))
			
			.whenPressed("Button3",3,new ShiftToggleCommand(getRobot(), "ShiftToggle"))
			.whenPressed("Button4",4,new MDMoveCommand(getRobot(),"reverse command",Direction.reverse))
			.whenPressed("Button5",5,new RopeRiseCommand(getRobot(), "RopeRiseCommand"))
//			.whenPressed("Button6",6,new MDMoveCommand(getRobot(),"forward command",Direction.forward))
			.whenPressed("Button6",6,new UnjamBallsystemCommand(getRobot(),"UnjamBallsystemCommand"))
//			.whenPressed("Button7",7,new ShootCommand(getRobot(),"ShootCommand"))
			.whenPressed("Button11",11,new StopShootSystemCommand(getRobot(),"StopShootSystemCommand"))
			.whenPressed("Button12",12,new UnjamShootCommand(getRobot(),"UnjamShootCommand"))
			.configure()
		);

		//Configure the RioHID here
		// Uncomment the following to attach a command to the user button on the RoboRio
		add(new RioHID(getRobot())
			.whileHeld(new MDPrintCommand(getRobot(),"ExampleCommand1","ExampleCommand1 message"))
			.configure()
		);
		
		
		//Configure the MDConsole OI here		
		add(new ConsoleOI(getRobot())
				.whenPressed("Command1",0,new MDPrintCommand(getRobot(),"Command1","Command1 message"))
				.configure()
			);		
		
	}

}  


