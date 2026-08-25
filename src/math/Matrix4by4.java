package math;

public class Matrix4by4 {
	
	private float[] matrix = new float[16];
	
	public Matrix4by4() {
		setIdentity();
		
	}
	
	public void setIdentity() {
		for(int i = 0; i < 16; i++) {
			 matrix[i] = 0.0f;
		}
			matrix[0] = 1.0f;
			matrix[5] = 1.0f;
			matrix[10] = 1.0f;
			matrix[15] = 1.0f;	
	}
	
	public Vertex3D multiply(Vertex3D v) {
		
		float vx = v.x;
		float vy = v.y;
		float vz = v.z;
		float vw = 1.0f;
		
		
		float rx = matrix[0] * vx + matrix[1] * vy + matrix[2] * vz + matrix[3] * vw;
		float ry = matrix[4] * vx + matrix[5] * vy + matrix[6] * vz + matrix[7] * vw;
		float rz = matrix[8] * vx + matrix[9] * vy + matrix[10] * vz + matrix[11] * vw;
		float rw = matrix[12] * vx + matrix[13] * vy + matrix[14] * vz + matrix[15] * vw;
		
		//Divide by w (proyection)
		if(rw != 0.0f) {
			return new Vertex3D(rx/rw, ry/rw, rz/rw);
		} else {
			//Not a point, just a direction
			return new Vertex3D(rx, ry, rz);
		}
		
	}
	
//	public Vertex3D multiply(Matrix4by4 other) {
//		
//	}
//	
}
