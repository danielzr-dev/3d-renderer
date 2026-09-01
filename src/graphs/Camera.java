package graphs;

import math.Matrix4by4;
import math.Quaternion;
import math.Transformations;
import math.Vertex3D;

public class Camera {
	
	private Vertex3D position;
	private Quaternion rotation;
	
	public Camera(Vertex3D position, Quaternion rotation) {
		this.position = position;
		this.rotation = rotation;
		
	}
	
	public Matrix4by4 getViewMatrix() {

		//Inverse translation
		Matrix4by4 translateInv = Transformations.translation(
				-position.x, -position.y, -position.z
				);
			
		//Quaternion inverse
		Quaternion rotaQuaInv = new Quaternion(-rotation.x,
				-rotation.y, -rotation.z, rotation.w);
		Matrix4by4 rotateInv = rotaQuaInv.toRotationMatrix();
		
		//View = Rotate x Translate
		return rotateInv.multiply(translateInv);
			
	}

}
