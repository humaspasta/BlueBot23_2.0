package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.maps.RobotMap;

public class Vroom extends SubsystemBase {
    private final CCSparkMax frontLeft = new CCSparkMax("Front Left", "fl", RobotMap.FRONT_LEFT, MotorType.kBrushed, IdleMode.kBrake, RobotMap.FRONT_LEFT_REVERSE, false);
    private final CCSparkMax frontRight = new CCSparkMax("Front Right", "fr", RobotMap.FRONT_RIGHT, MotorType.kBrushed, IdleMode.kBrake, RobotMap.FRONT_RIGHT_REVERSE, false);
    private final CCSparkMax backLeft = new CCSparkMax("Back Left", "bl", RobotMap.BACK_LEFT, MotorType.kBrushed, IdleMode.kBrake, RobotMap.BACK_LEFT_REVERSE, false);
    private final CCSparkMax backRight = new CCSparkMax("Back Right", "br", RobotMap.BACK_RIGHT, MotorType.kBrushed, IdleMode.kBrake, RobotMap.BACK_RIGHT_REVERSE, false);

    MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
    MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

    DifferentialDrive difDrive = new DifferentialDrive(left, right);

    public void drive(double moveSpeed, double turnSpeed){
        difDrive.arcadeDrive(moveSpeed, turnSpeed);
    }
}
