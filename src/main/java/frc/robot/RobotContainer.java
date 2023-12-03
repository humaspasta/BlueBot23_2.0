// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.helpers.OI;
import frc.maps.ControlMap;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Succies;
import frc.robot.subsystems.Vroom;
import frc.robot.subsystems.Uppsies;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final Vroom vroom = new Vroom();

  private final Uppsies uppsies = new Uppsies();
  private final Succies succies = new Succies();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


    RunCommand VroomDefaultVroom = new RunCommand(()->{
      vroom.drive(OI.axis(0,ControlMap.L_JOYSTICK_VERTICAL), OI.axis(0,ControlMap.R_JOYSTICK_HORIZONTAL));

    }, vroom);

    vroom.setDefaultCommand(VroomDefaultVroom);

    RunCommand UppsiesDefaultUppsies = new RunCommand(()->{
      uppsies.INeedUppsies(OI.axis(1,ControlMap.L_JOYSTICK_VERTICAL));
      double pos = uppsies.uppsiesEncoder();
      if (pos > topPos || pos < bottomPos){
        uppsies.INeedUppsies(0);
      }
    }, uppsies);

    uppsies.setDefaultCommand(UppsiesDefaultUppsies);

    RunCommand SucciesDefaultSuccies = new RunCommand(() ->{

      double speed = 0;
      if(OI.axis(1, ControlMap.RT) > 0)
        speed = OI.axis(1, ControlMap.RT);
      else
        speed = -1 * OI.axis(1, ControlMap.LT);
      succies.INeedSucc(speed);
    } , succies);
    
    succies.setDefaultCommand(SucciesDefaultSuccies);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
