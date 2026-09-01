package test;

import math.Direction3D;
import math.Quaternion;

public class QuaternionTest {

	public static void main(String[] args) {
		//1. Identity Quaternion
		Quaternion q1 = new Quaternion();
		
		System.out.println(q1);
		
		//2. Quaternion angle and Z axis
		Direction3D axisZ = new Direction3D(0, 0, 1);
		Quaternion q2 = new Quaternion((float) Math.PI/2, axisZ);
		System.out.println(q2);
		
		
		//3.Quaternion angle and X axis
		Direction3D axisX = new Direction3D(1, 0, 0);
		Quaternion q3 = new Quaternion((float) Math.PI/2, axisX);
		System.out.println(q3);
		
	}

}
