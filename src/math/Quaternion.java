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
	
	public Matrix4by4 toRotationMatrix() {
		
		Matrix4by4 result = new Matrix4by4(true);
		
		//Row 0
		result.matrix[0] = 1 - 2*(y*y + z*z);
		result.matrix[1] = 2*(x*y - w*z);
		result.matrix[2] = 2*(x*z + w*y);
		result.matrix[3] = 0;
		
		//Row 1
		result.matrix[4] = 2*(x*y + w*z);
		result.matrix[5] = 1 - 2*(x*x + z*z);
		result.matrix[6] = 2*(y*z - w*z);
		result.matrix[7] = 0;
		
		//Row 2
		result.matrix[8] = 2*(x*z - w*y);
		result.matrix[9] = 2*(y*z + w*x);
		result.matrix[10] = 1 - 2*(x*x + y*y);
		result.matrix[11] = 0;
		
		//Row 3 (Identity)
		result.matrix[12] = 0;
		result.matrix[13] = 0;
		result.matrix[14] = 0;
		result.matrix[15] = 1;
		
		
		return result;
	}
	
	public Quaternion multiply(Quaternion other) {
		
		float nx = this.w * other.x + this.x * other.w + this.y * other.z - this.z * other.y;
		float ny = this.w * other.y - this.x * other.z + this.y * other.w + this.z * other.x;
		float nz = this.w * other.z + this.x * other.y - this.y * other.x + this.z * other.w;
		float nw = this.w * other.w - this.x * other.x - this.y * other.y - this.z * other.z;
		
		return new Quaternion(nx, ny, nz, nw);
	}
	
	public Quaternion normalize() {
		
		float magnitude = (float) Math.sqrt(x*x + y*y + z*z + w*w);
		
		if(magnitude == 0) {
			return new Quaternion(x,y,z,w);
		}

		return new Quaternion(x/magnitude, y/magnitude, z/magnitude, w/magnitude);
	}
	
	public Direction3D rotateVector(Direction3D vector) {
		
		Quaternion vQuat = new Quaternion(0, vector.getX(), vector.getY(), vector.getZ());
		Quaternion conjugate = new Quaternion(this.w, -this.x, -this.y, -this.z);
		
		Quaternion result = this.multiply(vQuat).multiply(conjugate);
		
		return new Direction3D(result.x, result.y, result.z);
		
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
