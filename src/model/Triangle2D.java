package model;

import java.awt.Color;

import math.Vertex;

public class Triangle2D {
	
	private Vertex a;
	private Vertex b;
	private Vertex c;
	private Color color;
	private float z_a, z_b, z_c;
	
	public Triangle2D(Vertex a, Vertex b, Vertex c, Color color,
					  float z_a, float z_b, float z_c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.z_a = z_a;
		this.z_b = z_b;
		this.z_c = z_c;
		
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
	
	public float getZ_a() {
		return z_a;
	}

	public float getZ_b() {
		return z_b;
	}

	public float getZ_c() {
		return z_c;
	}
	
	
}
