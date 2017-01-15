package org.usfirst.frc.team4141.MDRobotBase;

import org.usfirst.frc.team4141.MDRobotBase.notifications.RobotLogNotification;
import org.usfirst.frc.team4141.robot.subsystems.WebSocketSubsystem;

public class Logger {
	

	public enum Level{
		DEBUG,
		INFO,
		ERROR
	}
	private MDRobotBase robot;
	public MDRobotBase getRobot() {
		return robot;
	}
	public Logger(MDRobotBase robot){
		this.robot=robot;
	}
	
	public void log(Level level,String logOrigin, String message, boolean showInConsole, String target, boolean record)
	{		
		getRobot().post(new RobotLogNotification(level, logOrigin, message, showInConsole, target, record));
	}
	
	public void log(String logOrigin, String message)
	{
		log(Level.INFO,logOrigin,message);
	}
	
	public void debug(String logOrigin, String message)
	{
		log(Level.DEBUG,logOrigin,message);
	}
	
	public void log(Level level,String logOrigin, String message)
	{
		switch(level){
		case DEBUG:
			log(level,logOrigin,message,true,null,false);
			break;
		case ERROR:
			log(level,logOrigin,message,true,WebSocketSubsystem.Remote.console.toString(),true);
			break;
		default:
			log(level,logOrigin,message,false,WebSocketSubsystem.Remote.console.toString(),false);
		}
	}
}
