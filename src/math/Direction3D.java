package math;

public class Direction3D {
	
	public float x, y, z, w;

	public Direction3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 0.0f;
		
	}
	
	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y + z * z);
		
	}
	
	public Direction3D normalize() {
		
		float mag = magnitude();
		if(mag <= 0.0f) {
			throw new IllegalArgumentException("Magnitude must be greater than zero");
		}
		
		float normalizedX = this.x / mag;
		float normalizedY = this.y / mag;
		float normalizedZ = this.z / mag;
		
		return new Direction3D(normalizedX, normalizedY, normalizedZ);

	}

}
