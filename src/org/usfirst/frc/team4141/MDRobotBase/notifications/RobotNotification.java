package org.usfirst.frc.team4141.MDRobotBase.notifications;

import org.usfirst.frc.team4141.MDRobotBase.NotImplementedException;
import org.usfirst.frc.team4141.MDRobotBase.eventmanager.Notification;

import edu.wpi.first.wpilibj.Timer;

//TODO:Refactor broadcast to Notification class so that dependency is cleaner.  see MSee

public abstract class RobotNotification extends Notification {
	private double fpgaTime;
	public double getFpgaTime() {
		return fpgaTime;
	}
	public RobotNotification(String notificationType){
		this(notificationType,false);
	}
	public RobotNotification(String notificationType,boolean showJavaConsole){
		this(notificationType,showJavaConsole,false,false,false);
	}
	public RobotNotification(String notificationType,boolean showJavaConsole,boolean display,boolean broadcast,boolean record){
		super(notificationType,showJavaConsole,broadcast,record,display);
		this.fpgaTime = Timer.getFPGATimestamp();
	}


/*
{"eventType": "targetAcquiredNotification", "messageId":7, "timestamp": 1456619634747, "targetAcquired":true}
{"eventType": "goodShotNotification", "messageId":9, "timestamp": 1456619634747, "GoodShot":true}
 */
	@Override
	public Notification parse(String arg0) {
		throw new NotImplementedException();
	}

	@Override
	public String toJSON() {
		sb = new StringBuilder();
		sb.append('{');
		if(getMessageId()>-1){
			sb.append(String.format("\"messageId\":%1$d, ",getMessageId()));
		}
		sb.append("\"eventType\":\"");
		sb.append(getNotificationType());
		sb.append("\",\"display\":");
		sb.append(this.dislay());
		sb.append(",\"record\":");
		sb.append(this.record());
		addJSONPayload();
		sb.append('}');
		return sb.toString();
	}		
		
}
