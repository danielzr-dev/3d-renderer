package rendering;

import math.Matrix4by4;
import math.Vertex;
import math.Vertex3D;

public class TransformPipeline {
	
	private Matrix4by4 modelMatrix;
	private Matrix4by4 viewMatrix;
	private Matrix4by4 projectionMatrix;

	public TransformPipeline(Matrix4by4 model, Matrix4by4 view, Matrix4by4 projection) {
		this.modelMatrix = model;
		this.viewMatrix = view;
		this.projectionMatrix = projection;
			
	}
	
	public Vertex transformVertex(Vertex3D ver3D, Matrix4by4 triTransform, int screenWith, int screenHeight) {
		
		if(triTransform == null) {
			triTransform = new Matrix4by4();
		}
		
		Vertex3D v1 = triTransform.multiply(ver3D);  
		Vertex3D v2 = modelMatrix.multiply(v1);
		Vertex3D v3 = viewMatrix.multiply(v2);
		Vertex3D v4 = projectionMatrix.multiply(v3);
	
		return mapToViewport(v4, screenWith, screenHeight );
	
	}
	
	private Vertex mapToViewport(Vertex3D v3D, int width, int height) {
		float screenX = (v3D.x + 1) * width /2;
		float screenY = (1 - v3D.y) * height / 2;
		
		return new Vertex(screenX, screenY, v3D.z);
	}

}
