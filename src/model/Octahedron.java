package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import math.Matrix4by4;
import math.Vertex3D;

public class Octahedron implements Model3D {
	
	private Vertex3D[] vertices = new Vertex3D[6];
	private Triangle3D[] triangles = new Triangle3D[8];
	private Matrix4by4 currentTransform = new Matrix4by4(); 
	
	public Octahedron() {
		
	    vertices[0] = new Vertex3D(-0.5f, 0.0f, 0.0f);  
	    vertices[1] = new Vertex3D(0.0f, 0.0f, -0.5f);  
	    vertices[2] = new Vertex3D(0.5f, 0.0f, 0.0f);  
	    vertices[3] = new Vertex3D(0.0f, 0.0f, 0.5f);   
	    vertices[4] = new Vertex3D(0.0f, 0.5f, 0.0f);    
	    vertices[5] = new Vertex3D(0.0f, -0.5f, 0.0f);  
	    
	    // Top pyramid (V4)
	    triangles[0] = new Triangle3D(vertices[0], vertices[1], vertices[4], Color.RED);
	    triangles[1] = new Triangle3D(vertices[1], vertices[2], vertices[4], Color.BLUE);
	    triangles[2] = new Triangle3D(vertices[3], vertices[2], vertices[4], Color.GREEN);
	    triangles[3] = new Triangle3D(vertices[0], vertices[3], vertices[4], Color.YELLOW);
	    
	    // Bottom pyramid (V5)
	    triangles[4] = new Triangle3D(vertices[0], vertices[5], vertices[1], Color.CYAN);
	    triangles[5] = new Triangle3D(vertices[1], vertices[5], vertices[2], Color.MAGENTA);
	    triangles[6] = new Triangle3D(vertices[3], vertices[5], vertices[2], Color.ORANGE);
	    triangles[7] = new Triangle3D(vertices[0], vertices[5], vertices[3], Color.PINK);
	   
	   
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
