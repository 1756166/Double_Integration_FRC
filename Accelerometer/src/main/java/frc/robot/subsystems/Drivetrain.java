/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // Drivetrain Talons 
  private WPI_TalonSRX talon_fl = new WPI_TalonSRX(Constants.talon_fl_port);
  private WPI_TalonSRX talon_fr = new WPI_TalonSRX(Constants.talon_fl_port);
  private WPI_TalonSRX talon_bl = new WPI_TalonSRX(Constants.talon_fl_port);
  private WPI_TalonSRX talon_br = new WPI_TalonSRX(Constants.talon_fl_port);
  
  // Deadzone Constant
  private final double deadzone = 0.1;
  public void tank_drive(double left_val, double right_val){
    // Left side
    if (Math.abs(left_val) < deadzone){
      talon_fl.set(0);
      talon_bl.set(0);
    } else {
      talon_fl.set(left_val);
      talon_bl.set(left_val);
    }
    
    // Right side
    if (Math.abs(right_val) < deadzone){
      talon_fr.set(0);
      talon_br.set(0);
    } else {
      talon_fr.set(right_val);
      talon_br.set(right_val);
    }
  }

  public Drivetrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
