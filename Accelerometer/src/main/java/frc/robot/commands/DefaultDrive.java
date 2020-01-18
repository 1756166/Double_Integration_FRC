/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlFrame;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Accelerometer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.controls.Contollers;

public class DefaultDrive extends CommandBase {
  // Integration variables
  double init_accel = 0, init_veloc = 0, init_pos = 0;
  Timer game_timer = new Timer();
  
  private Drivetrain s_drivetrain;
  public DefaultDrive(Drivetrain drivetrain) {
    s_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    game_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double old_t = Timer.getMatchTime();
    double left_val = Contollers.driver.getRawAxis(0), right_val = Contollers.driver.getRawAxis(1);
    s_drivetrain.tank_drive(left_val, right_val);
    double new_t = Timer.getMatchTime();
    double dt = new_t - old_t;
    double integrated_veloc = Accelerometer.integrate_veloc(0, 0, Accelerometer.get_imu().getAccelX(), Accelerometer.get_imu().getAccelY(), dt, 2)
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
