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
