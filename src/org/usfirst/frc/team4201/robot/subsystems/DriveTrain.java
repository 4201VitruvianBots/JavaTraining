package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
	
	/** Initializing motors in an arrray
	 */
	CANTalon[] leftMotors = new CANTalon[] {
		new CANTalon(RobotMap.driveTrainLeftFront),
		new CANTalon(RobotMap.driveTrainLeftCenter),
		new CANTalon(RobotMap.driveTrainLeftRear)
	};
	CANTalon[] rightMotors = new CANTalon[] {
		new CANTalon(RobotMap.driveTrainRightFront),
		new CANTalon(RobotMap.driveTrainRightCenter),
		new CANTalon(RobotMap.driveTrainRightRear)
	};
	
	/** Initializing the RobotDrive as a 4-motors drivetrain and selecting which motors are used.
	 */
	RobotDrive robotDrive = new RobotDrive(leftMotors[0], leftMotors[1], rightMotors[0], rightMotors[1]);
	
	public DriveTrain(){
		/** Initialize the subsystem
		 */
		super();
		
		/** Set control modes for the drive motors
		 */
		leftMotors[0].changeControlMode(TalonControlMode.PercentVbus);
		leftMotors[1].changeControlMode(TalonControlMode.PercentVbus);
		leftMotors[2].changeControlMode(TalonControlMode.Speed);
		rightMotors[0].changeControlMode(TalonControlMode.PercentVbus);
		rightMotors[1].changeControlMode(TalonControlMode.PercentVbus);
		rightMotors[2].changeControlMode(TalonControlMode.Speed);
		
		/** Add code below to display data onto the DriverStation
		 */
	}
	
	/** Function to initialize the drive motors so that values can be directly set to control them.
	 */
	public void setDrioveControlByPower() {
		leftMotors[0].changeControlMode(TalonControlMode.PercentVbus);
		leftMotors[1].changeControlMode(TalonControlMode.PercentVbus);
		rightMotors[0].changeControlMode(TalonControlMode.PercentVbus);
		rightMotors[1].changeControlMode(TalonControlMode.PercentVbus);
		leftMotors[0].configPeakOutputVoltage(+12.0f, -12.0f);
		leftMotors[1].configPeakOutputVoltage(+12.0f, -12.0f);
		rightMotors[0].configPeakOutputVoltage(+12.0f, -12.0f);
		rightMotors[1].configPeakOutputVoltage(+12.0f, -12.0f);
		
		robotDrive.setSafetyEnabled(true);
	}
	
	/** Function to set control to Joysticks in Tank Drive
	 */
	public void driveWithJoysticks(Joystick leftJoystick, Joystick rightJoystick) {
		leftMotors[0].clearStickyFaults();
		leftMotors[1].clearStickyFaults();
		rightMotors[0].clearStickyFaults();
		rightMotors[1].clearStickyFaults();
		
		robotDrive.tankDrive(leftJoystick, rightJoystick);
	}
	
	/** Add any additional functions related to the DriveTrain below
	 */
	
	/** All Subsystems must incorporate the following function.
	 * The function must set a default command to use in order to operate.
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
