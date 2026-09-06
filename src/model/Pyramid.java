package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import math.Matrix4by4;
import math.Vertex3D;

public class Pyramid implements Model3D {
	
	private Vertex3D[] vertices = new Vertex3D[5];
	private Triangle3D[] triangles = new Triangle3D[6];
	private Matrix4by4 currentTransform = new Matrix4by4(); 
	
	public Pyramid() {
		
		//Counter clock-wise
		vertices[0] = new Vertex3D(-0.5f, -0.5f, -0.5f);
		vertices[1] = new Vertex3D(0.5f, -0.5f, -0.5f);
		vertices[2] = new Vertex3D(0.5f, -0.5f, 0.5f);
		vertices[3] = new Vertex3D(-0.5f, -0.5f, 0.5f);
		
		vertices[4] = new Vertex3D(0.0f, 0.5f, 0.0f);
		
		//Base Triangle 1 (front left)
		triangles[0] = new Triangle3D(vertices[0],vertices[2],vertices[1], Color.GREEN);
		//Base triangle 2 (back right)
		triangles[1] = new Triangle3D(vertices[0],vertices[3],vertices[2], Color.MAGENTA);
		
		//Side faces (4 triangles)
		triangles[2] = new Triangle3D(vertices[0],vertices[1],vertices[4], Color.BLUE);
		triangles[3] = new Triangle3D(vertices[1],vertices[2],vertices[4], Color.RED);
		triangles[4] = new Triangle3D(vertices[2],vertices[4],vertices[3], Color.WHITE);
		triangles[5] = new Triangle3D(vertices[3],vertices[0],vertices[4], Color.ORANGE);
		
	}

	@Override
	public List<Triangle3D> getTriangles() {
		return Arrays.asList(triangles);
		
	}

	@Override
	public void setTransform(Matrix4by4 transform) {
		this.currentTransform = transform;
		
	}

	@Override
	public Matrix4by4 getTransform() {
		return currentTransform;
		
	}
	
	
}
