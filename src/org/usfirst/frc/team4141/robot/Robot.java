package org.usfirst.frc.team4141.robot;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MDDigitalInput;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MD_BuiltInAccelerometer;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MD_IMU;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.config.StringConfigSetting;
import org.usfirst.frc.team4141.robot.commands.MDStopCommand;
import org.usfirst.frc.team4141.robot.subsystems.CoreSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem;
import org.usfirst.frc.team4141.robot.subsystems.BallSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem.MotorPosition;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem.Type;
import org.usfirst.frc.team4141.robot.subsystems.RopeSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.ShootSubsystem;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends MDRobotBase {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

	@Override
	protected void configureRobot() {

		//A commands needs to be configured for the autonomous mode.
		//In some cases it is desirable to have more than 1 auto command and make a decision at game time which command to use
		setAutonomousCommand(new MDCommand[]{
				new MDStopCommand(this,"StopCommand")
			}, "StopCommand"  //specify the default
		);

		//Subsystem to manage robot wide config settings
		add( new CoreSubsystem(this, "core")
				 .add("name",new StringConfigSetting("MaterBot"))					//go ahead name your robot
				 .add("autoCommand",new StringConfigSetting("StopCommand"))		//name of autoCommand you wish to start with
				 .configure()
		);		
		
		//A robot is composed of subsystems
		//A robot will typically have 1 drive system and several other fit to purpose subsystems		
		//The Drive system is a special subsystem in that it has specific logic handle the speed controllers
		//We have 2 types of drive systems, tank drive and mecanum drive
		//uncomment the desired drive system and adjust the motor configuration as needed
		//Mecanum example :
/*		add(new MDDriveSubsystem(this, "driveSystem", Type.MecanumDrive)
				.add(MotorPosition.frontRight, new Victor(1))
				.add(MotorPosition.rearRight, new Victor(0))
				.add(MotorPosition.frontLeft, new Victor(3))
				.add(MotorPosition.rearLeft, new Victor(2))
				.add("accelerometer", new MD_BuiltInAccelerometer())
				.add("IMU", new MD_IMU())
				.configure()
		);	
*/



// TankDrive with 2 motors example:
/*		
		add(new MDDriveSubsystem(this, "driveSystem", Type.TankDrive)
				.add(MotorPosition.right, new Victor(0))
				.add(MotorPosition.left, new Victor(1))
				.add("accelerometer", new MD_BuiltInAccelerometer())
				.add("IMU", new MD_IMU())
				.configure()
		);	
*/		
// TankDrive with 4 motors example:

		add(new MDDriveSubsystem(this, "driveSystem", Type.TankDrive)
				.add(MotorPosition.frontRight, new Victor(0))
				.add(MotorPosition.rearRight, new Victor(1))
				.add(MotorPosition.frontLeft, new Victor(2))
				.add(MotorPosition.rearLeft, new Victor(3))
				.add("accelerometer", new MD_BuiltInAccelerometer())
				.add("IMU", new MD_IMU())
				.configure()
		);	
	

		
		add(new GearSubSystem(this, "gearSubsystem")
				.add(GearSubSystem.SolenoidPosition.left.toString(), new Solenoid(0))
				.add(GearSubSystem.SolenoidPosition.right.toString(), new Solenoid(1))
				.add(GearSubSystem.motorName, new Victor(4))
				.add(GearSubSystem.SwitchPosition.extended.toString(), new MDDigitalInput(GearSubSystem.SwitchPosition.extended.toString(), 2))
				.add(GearSubSystem.SwitchPosition.recessed.toString(), new MDDigitalInput(GearSubSystem.SwitchPosition.recessed.toString(), 3))
				.configure());
		
		add(new BallSubsystem(this, "ballSubsystem")
				.add(BallSubsystem.motorName, new Victor(5))
			//	.add(BallSubsystem.?
				.configure());

		add(new RopeSubsystem(this, "ropeSubsystem")
				.add(RopeSubsystem.motorName, new Victor(6))
				.add(RopeSubsystem.RopeSensor.up.toString(), new MDDigitalInput(RopeSubsystem.RopeSensor.up.toString(), 4))
				.add(RopeSubsystem.RopeSensor.down.toString(), new MDDigitalInput(RopeSubsystem.RopeSensor.up.toString(), 5))
				.configure());
		
		add(new ShootSubsystem(this, "shootSubsystem")
				.add(ShootSubsystem.motorName, new Victor(7))
				.add(ShootSubsystem.motorName1, new Victor(8))
				.configure());

	}



	
	//Override lifecycle methods, as needed
	//	@Override
	//	public void teleopPeriodic() {
	//		super.teleopPeriodic();
	//		...
	//	}
	//	@Override
	//	public void autonomousPeriodic() {
	//		super.autonomousPeriodic();
	//		...
	//	}	
	
		
		//Event manager WebSocket related methods
		//Override as needed
	//	@Override
	//	public void onConnect(Session session) {
	//		super.onConnect(session);
	//		...
	//	}
		
}
