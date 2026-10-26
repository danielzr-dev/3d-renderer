package rendering;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import math.Vertex;

public class WireframeRasterizer {
	
	private BufferedImage bufferedImage;
	private Graphics g2d;
	private Color edgeColor;
	
	public WireframeRasterizer(BufferedImage bufferedImage, Color edgeColor) {
		this.bufferedImage = bufferedImage;
		this.g2d = (Graphics2D) bufferedImage.createGraphics();
		this.edgeColor = edgeColor;
		((Graphics2D) this.g2d).setStroke(new BasicStroke(1.0f));
		
	}
	
	public void drawWireframeTriangle(Vertex v1, Vertex v2, Vertex v3) {
		
		int x1 = (int) v1.getX();
		int y1 = (int) v1.getY();
		int x2 = (int) v2.getX();
		int y2 = (int) v2.getY();
		int x3 = (int) v3.getX();
		int y3 = (int) v3.getY();
		
		//Draws the 3 edges
		g2d.setColor(edgeColor);
		g2d.drawLine(x1, y1, x2, y2);
		g2d.drawLine(x2, y2, x3, y3);
		g2d.drawLine(x3, y3, x1, y1);
		
	}

	public void dispose() {
		g2d.dispose();
		
	}
}
