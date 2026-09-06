package rendering;

import java.util.List;

import math.Direction3D;
import math.Matrix4by4;
import math.Transformations;
import model.Model3D;



public class ModelRenderer {

	private Model3D activeModel;
	private float rotationX= 0f;
	private float rotationY= 0f;
	private float rotationZ= 0f;
	private Matrix4by4 currentTransformMatrix = new Matrix4by4();
	
	public ModelRenderer(Model3D initialModel) {
		this.activeModel = initialModel;
		updateTransformMatrix();
	}
		
	
	public void updateRotation(float deltaX, float deltaY, float deltaZ) {
		this.rotationX += deltaX;
		this.rotationY += deltaY;
		this.rotationZ += deltaZ;
		updateTransformMatrix();
		
	}
	
	private void updateTransformMatrix() {
		Direction3D xAxis = new Direction3D(1, 0, 0);
		Direction3D yAxis = new Direction3D(0, 1, 0);
		Direction3D zAxis = new Direction3D(0, 0, 1);
		
		Matrix4by4 rotaX = Transformations.rotation(rotationX, xAxis);
		Matrix4by4 rotaY = Transformations.rotation(rotationY, yAxis);
		Matrix4by4 rotaZ = Transformations.rotation(rotationZ, zAxis);
		
		this.currentTransformMatrix = rotaX.multiply(rotaY).multiply(rotaZ);
		
		if(activeModel != null) {
			activeModel.setTransform(currentTransformMatrix);
		}
		
	}
	
	public Matrix4by4 getTransformMatrix() {
		return currentTransformMatrix;
		
	}
	
	public void setActiveModel(Model3D model) {
		this.activeModel = model;
		updateTransformMatrix();
	}
	
	public Model3D getActiveModel() {
		return activeModel;
	}
	
	public float[] getRotationDegrees() {
		return new float[] {
				(float) Math.toDegrees(rotationX),
				(float) Math.toDegrees(rotationY),
				(float) Math.toDegrees(rotationZ)
		};
	}
	

}
