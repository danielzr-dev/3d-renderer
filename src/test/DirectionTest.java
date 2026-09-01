package test;

import math.Direction3D;

public class DirectionTest {
	public static void main(String[]args) {
		//1.Create direction
		Direction3D dir = new Direction3D(3, 4, 0);
		System.out.println("Magnitude: " + dir.magnitude());
		
		//Expected: 5.0
		
		//2.Normalize
		Direction3D norm = dir.normalize();
		System.out.println("Normalized: " + norm.x +  ", "
										  + norm.y +  ", "
										  + norm.z);
		
		//Expected: ~0.6, ~0.8, 0
		
		//3. Original
		System.out.println("Original: " + dir.x + ", " + dir.y + ", " + dir.z);
		
		//Expected: 3, 4, 0 (no changes)
		
		//4. Magnitude equals  0 (exception)
		
		try {
			Direction3D zero = new Direction3D(0, 0, 0);
			zero.normalize();
			
		} catch (IllegalArgumentException e) {
			System.out.println("Captured exception: " + e.getMessage());
			
		}
		
		
	}
	
}
