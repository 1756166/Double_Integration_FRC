/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controls;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Contollers {
    public static Joystick driver = new Joystick(Constants.joystick_driver_port);
    public static Joystick gunner = new Joystick(Constants.joysticK_gunner_port);
}
