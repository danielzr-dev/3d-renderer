package rendering;

import java.awt.Color;
import java.awt.image.BufferedImage;

import math.PointInTriangle;
import math.Vertex;
import model.Triangle2D;

public class TriangleRasterizer {
	
	private BufferedImage bufferedImage;
	
	public TriangleRasterizer(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	public void paintPixel(int x, int y, Color color) {
		if( x>= 0 && x < bufferedImage.getWidth() &&
			y>= 0 && y < bufferedImage.getHeight()) {
			bufferedImage.setRGB(x, y, color.getRGB());
			
		}

	}
	
	public void paintTriangle(Triangle2D tri) {
		Vertex a = tri.getA();
		Vertex b = tri.getB();
		Vertex c = tri.getC();
		Color color = tri.getColor();
		
		int[] delimTriangle = calcDelimitation(tri);
		int minX = delimTriangle[0];
		int maxX = delimTriangle[1];
		int minY = delimTriangle[2];
		int maxY = delimTriangle[3];
		
		for(int y = minY; y <= maxY; y++) {
			for(int x = minX; x<= maxX; x++) {
				if(PointInTriangle.isInside(a, b, c, x, y)) {
					paintPixel(x, y, color);
				}
			}
		}
		
	}
	
	private int[] calcDelimitation(Triangle2D tri) {
		double maxX = Math.max(tri.getA().getX(), Math.max(tri.getB().getX(), tri.getC().getX()));
		double minX = Math.min(tri.getA().getX(), Math.min(tri.getB().getX(), tri.getC().getX()));
		double maxY = Math.max(tri.getA().getY(), Math.max(tri.getB().getY(), tri.getC().getY()));
		double minY = Math.min(tri.getA().getY(), Math.min(tri.getB().getY(), tri.getC().getY()));
		
		//Clamp for viewport
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		
		minX = Math.max((int) minX, 0);
		maxX  = Math.min((int) maxX, width-1);
		minY = Math.max((int) minY, 0);
		maxY = Math.min((int) maxY, height -1);
		
		return new int[] {(int) minX, (int) maxX, (int) minY, (int) maxY};
	}

}
