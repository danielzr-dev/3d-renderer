package math;

public class Transformations {


	public static Matrix4by4 translation(float x, float y, float z) {
	
		Matrix4by4 result = new Matrix4by4(true); //Empty matrix
				
		//Identity first
		result.matrix[0] = 1.0f;
		result.matrix[5] = 1.0f;
		result.matrix[10] = 1.0f;
		result.matrix[15] = 1.0f;
		
		//Translation
		result.matrix[3] = x;
		result.matrix[7] = y;
		result.matrix[11] = z;
				
		return result;
		
	}
	
	  public static Matrix4by4 rotation(float angle, Direction3D axis) {
	  
		  Quaternion q = new Quaternion(angle, axis);
		  return q.toRotationMatrix();	  
	  
	  }
	 
	
	public static Matrix4by4 scale(float x, float y, float z) {
		
	Matrix4by4 result = new Matrix4by4(true);
		
	//Scale matrix
		result.matrix[0] = x;
		result.matrix[5] = y;
		result.matrix[10] = z;
		result.matrix[15] = 1.0f;
		
		return result;
	}
	
	public Matrix4by4 toRotationMatrix() {
		
		Matrix4by4 result = new Matrix4by4(true);
		
		
		return result;
	}
	
	public static Matrix4by4 perspective(float fov, float aspRatio, float zNear, float zFar) {
		
		Matrix4by4 result = new Matrix4by4(true);
		float fovToRadian  = (float) Math.toRadians(fov);
		
		//Row 0
		result.matrix[0] = 1 / (aspRatio * (float) Math.tan(fovToRadian/2));
		
		//Row 1
		result.matrix[5] = 1 / (float) Math.tan(fovToRadian/2);
		
		//Row 2
		result.matrix[10] = -(zFar + zNear)/(zFar - zNear);
		result.matrix[11] = -(2 * zFar * zNear)/(zFar - zNear);
		
		//Row 3
		result.matrix[14] = -1.0f;
		
		
		return result;
		
		
	}
	
}
