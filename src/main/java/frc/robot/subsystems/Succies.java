package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.maps.RobotMap;


public class Succies extends SubsystemBase{
    private final CCSparkMax intake = new CCSparkMax("Intake One", "BO", RobotMap.INTAKE_TOP, MotorType.kBrushless, IdleMode.kBrake, RobotMap.INTAKE_TOP_REVERSE, RobotMap.DRIVE_ENCODER);


    public void INeedSucc(double Speeed){
        intake.set(Speeed);
    }
}//jasicnhdslcbjcbdewkjcb wkjcb ewkjcb,