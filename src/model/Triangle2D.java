package model;

import java.awt.Color;

import math.Vertex;

public class Triangle2D {
	
	private Vertex a;
	private Vertex b;
	private Vertex c;
	private Color color;
	
	public Triangle2D(Vertex a, Vertex b, Vertex c, Color color) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
	}

	public Vertex getA() {
		return a;
		
	}

	public Vertex getB() {
		return b;
		
	}

	public Vertex getC() {
		return c;
		
	}
	
	public Color getColor() {
		return color;
		
	}
	
	
}
