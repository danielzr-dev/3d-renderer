package math;

public class Vertex3D {
	
	public float x;
	public float y;
	public float z;
	public float w;
	
	public Vertex3D(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 1.0f;
		
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
		
	}


	public double getZ() {
		return z;
		
	}
	
	public Direction3D subtract(Vertex3D other) {
		
		return new Direction3D(this.x - other.x, this.y -other.y, this.z - other.z);
	}
	

}
