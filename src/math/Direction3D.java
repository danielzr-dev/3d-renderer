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
	
	public Direction3D crossProduct(Direction3D other) {
		
		return new Direction3D(this.y * other.z - this.z * other.y,
	            			   this.z * other.x - this.x * other.z,
	                           this.x * other.y - this.y * other.x);
		
	}
	
	public float dotProduct(Direction3D other) {
		
		return (this.x * other.x) + (this.y * other.y) + (this.z * other.z);
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getW() {
		return w;
	}

	
}
