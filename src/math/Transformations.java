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
	
	public static Matrix4by4 rotation(float x, float y, float z) {
		

		
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
	
}
