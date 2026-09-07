package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import math.Matrix4by4;
import math.Vertex3D;

public class Tetrahedron implements Model3D {

	private Vertex3D[] vertices = new Vertex3D[4];
	private Triangle3D[] triangles = new Triangle3D[4];
	private Matrix4by4 currentTransform = new Matrix4by4(); 
	
	public Tetrahedron() {
		
	    vertices[0] = new Vertex3D(0.0f, 0.5f, 0.0f);     
	    vertices[1] = new Vertex3D(-0.5f, -0.5f, -0.5f);   
	    vertices[2] = new Vertex3D(0.5f, -0.5f, -0.5f);    
	    vertices[3] = new Vertex3D(0.0f, -0.5f, 0.5f);     
	    
	    // Base 
	    triangles[0] = new Triangle3D(vertices[1], vertices[3], vertices[2], Color.BLUE);
	    
	    triangles[1] = new Triangle3D(vertices[0], vertices[1], vertices[2], Color.RED);
	    triangles[2] = new Triangle3D(vertices[0], vertices[3], vertices[2], Color.GREEN);
	    triangles[3] = new Triangle3D(vertices[0], vertices[1], vertices[3], Color.YELLOW);
		
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
