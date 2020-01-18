/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.analog.adis16448.frc.ADIS16448_IMU.Axis;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Accelerometer extends SubsystemBase {
  /**
   * Creates a new Accelerometer.
   */
  private static ADIS16448_IMU imu = new ADIS16448_IMU(Axis.kZ);;

  private static double get_true_vector(double vector_x, double vector_y){
    return Math.hypot(vector_x, vector_y);
  }
  private static double get_velocity(double init_accel, double new_accel, double dt){
    return (new_accel-init_accel) * dt;
  }

  private static double get_position(double init_velocity, double new_velocity, double dt){
    return (new_velocity-init_velocity) * dt;    
  }
  
  // Recursive method for integrating velocity. Hope this works......
  public static double integrate_veloc(double init_accel_x, double init_accel_y, double new_accel_x, double new_accel_y, double dt, double recursion_counter){
    if (recursion_counter == 0) return 0;
    else {
      double init_true_accel = get_true_vector(init_accel_x, init_accel_y), new_true_accel = get_true_vector(new_accel_x, new_accel_y);
      return get_velocity(init_true_accel, new_true_accel, dt) + integrate_veloc(new_accel_x, new_accel_y, imu.getAccelX(), imu.getAccelY(), dt, recursion_counter-1);
    }
  }

  public Accelerometer() {
    
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static ADIS16448_IMU get_imu(){
    return imu;
  }
}
