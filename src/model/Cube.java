package model;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import math.Vertex3D;

public class Cube {
	
	private Vertex3D[] vertices = new Vertex3D[8];
	private  Triangle3D[] triangles = new Triangle3D[12];
	
	public Cube() {
		
		//8 vertices
		//Front face, clockwise vertices starting from top left corner
		vertices[0] = new Vertex3D(-0.5f, 0.5f, 0.5f);
		vertices[1] = new Vertex3D(0.5f, 0.5f, 0.5f);
		vertices[2] = new Vertex3D(0.5f, -0.5f, 0.5f);
		vertices[3] = new Vertex3D(-0.5f, -0.5f, 0.5f);
		
		//Back face, clockwise vertices starting from top left corner
		vertices[4] = new Vertex3D(-0.5f, 0.5f, -0.5f);
		vertices[5] = new Vertex3D(0.5f, 0.5f, -0.5f);
		vertices[6] = new Vertex3D(0.5f, -0.5f, -0.5f);
		vertices[7] = new Vertex3D(-0.5f, -0.5f, -0.5f);
		
		//12 triangles
		//Front face
		triangles[0] = new Triangle3D(vertices[0], vertices[1], vertices[2], Color.MAGENTA);
		triangles[1] = new Triangle3D(vertices[0], vertices[2], vertices[3], Color.MAGENTA);
		
		//Back face
		triangles[2] = new Triangle3D(vertices[5], vertices[4], vertices[7], Color.GREEN);
		triangles[3] = new Triangle3D(vertices[5], vertices[7], vertices[6], Color.GREEN);
		
		//Left face
		triangles[4] = new Triangle3D(vertices[4], vertices[0], vertices[3], Color.BLUE);
		triangles[5] = new Triangle3D(vertices[4], vertices[3], vertices[7], Color.BLUE);
		
		//Right face
		triangles[6] = new Triangle3D(vertices[1], vertices[5], vertices[6], Color.WHITE);
		triangles[7] = new Triangle3D(vertices[1], vertices[6], vertices[2], Color.WHITE);
		
		//Top face
		triangles[8] = new Triangle3D(vertices[0], vertices[1], vertices[5], Color.LIGHT_GRAY);
		triangles[9] = new Triangle3D(vertices[0], vertices[5], vertices[4], Color.LIGHT_GRAY);
		
		//Bottom face
		triangles[10] = new Triangle3D(vertices[3], vertices[2], vertices[6], Color.ORANGE);
		triangles[11] = new Triangle3D(vertices[3], vertices[6], vertices[7], Color.ORANGE);
		
	}
	
	public List<Triangle3D> getTriangles() {
		return Arrays.asList(triangles);
	}
}
