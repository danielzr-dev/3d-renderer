package modelo;

import calculos.Vertice;
import java.awt.Color;

public class Triangulo {
	
	Vertice a;
	Vertice b;
	Vertice c;
	Color color;
	
	public Triangulo(Vertice a, Vertice b, Vertice c, Color color) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
	}
	
}
