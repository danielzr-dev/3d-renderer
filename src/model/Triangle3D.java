package model;

import java.awt.Color;

import math.Matrix4by4;
import math.Vertex3D;

public class Triangle3D {

	private Vertex3D a;
	private Vertex3D b;
	private Vertex3D c;
	private Color color;
	private Matrix4by4 transformMatrix;
	

	
	public Triangle3D(Vertex3D a, Vertex3D b, Vertex3D c, Color color) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		
	}

	public Triangle3D(Vertex3D a, Vertex3D b, Vertex3D c, Color color, Matrix4by4 transform) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.transformMatrix = transform;
		
	}

	public Vertex3D getA() {
		return a;
	}

	public Vertex3D getB() {
		return b;
	}

	public Vertex3D getC() {
		return c;
	}

	public Color getColor() {
		return color;
	}
	
	public Matrix4by4 getTransformMatrix() {
		return transformMatrix;
		
	}

}
