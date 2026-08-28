package math;

public class Quaternion {

	public float x, y, z, w, halfAngle;
	

	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Quaternion() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.w = 1.0f;
		
	}
	
	public Quaternion(float angle, Direction3D axis) {
		Direction3D normalized = axis.normalize();
		halfAngle = angle/2;
		
		this.w = (float) Math.cos(halfAngle);
		this.x = normalized.x * (float) Math.sin(halfAngle);
		this.y = normalized.y * (float) Math.sin(halfAngle);
		this.z = normalized.z * (float) Math.sin(halfAngle);
		
		
	}
	
	@Override
	public String toString() {
	    return "Quaternion{" +
	            "x=" + x +
	            ", y=" + y +
	            ", z=" + z +
	            ", w=" + w +
	            '}';
	}
	
}
