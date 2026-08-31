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
	
	public Vertex transformVertex(Vertex3D ver3D, int screenWith, int screenHeight) {
		Vertex v = new Vertex(screenHeight, screenHeight);
		Vertex3D v1 = modelMatrix.multiply(ver3D);
		Vertex3D v2 = viewMatrix.multiply(v1);
		Vertex3D v3 = projectionMatrix.multiply(v2);
	
		return mapToViewport(v3, screenWith, screenHeight );
	
	}
	
	private Vertex mapToViewport(Vertex3D v3D, int width, int height) {
		float screenX = (v3D.x + 1) * width /2;
		float screenY = (1 - v3D.y) * height / 2;
		
		return new Vertex(screenX, screenY);
	}

}
