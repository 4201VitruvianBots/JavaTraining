package org.usfirst.frc.team4201.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	/** The variables you declare here will be used as global variables to be used throughout the rest of the code.
	 * 	This is useful so you don't have to constantly change variables throughout your code, you only need to change their
	 *  values here.
	 */
	
	// These variables are for the CANTalon Addresses of Vitruvius
	public static final int driveTrainRightFront = 1;
	public static final int driveTrainRightCenter = 2;
	public static final int driveTrainRightRear = 3;
	public static final int driveTrainLeftFront = 10;
	public static final int driveTrainLeftCenter = 11;
	public static final int driveTrainLeftRear = 12;
}
