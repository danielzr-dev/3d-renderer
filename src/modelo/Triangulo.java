package modelo;

import calculos.Vertice;
import java.awt.Color;

public class Triangulo {
	
	private Vertice a;
	private Vertice b;
	private Vertice c;
	private Color color;
	
	public Triangulo(Vertice a, Vertice b, Vertice c, Color color) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
	}

	public Vertice getA() {
		return a;
	}

	public Vertice getB() {
		return b;
	}

	public Vertice getC() {
		return c;
	}
	
	public Color getColor() {
		return color;
	}
	
	
}
