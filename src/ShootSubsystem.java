import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.MDSubsystem;
import org.usfirst.frc.team4141.MDRobotBase.config.ConfigSetting;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SolenoidPosition;
import org.usfirst.frc.team4141.robot.subsystems.GearSubSystem.SwitchPosition;

public class ShootSubsystem extends MDSubsystem {

	public ShootSubsystem(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
	
	public static String motorName="ballShootMotor";
	
	public MDSubsystem configure(){
		super.configure();
		if(getMotors()==null 
				|| !getMotors().containsKey(motorName))
			throw new IllegalArgumentException("Invalid motor configuration for ball shoot system.");
		return this;
	}	

	@Override
	protected void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void settingChangeListener(ConfigSetting setting) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
