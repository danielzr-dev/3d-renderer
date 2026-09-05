package rendering;

import java.awt.Color;
import java.awt.image.BufferedImage;

import math.PointInTriangle;
import math.Vertex;
import model.Triangle2D;

public class TriangleRasterizer {
	
	private BufferedImage bufferedImage;
	private float[][] depthBuffer;
	
	public TriangleRasterizer(BufferedImage bufferedImage, float[][] depthBuffer) {
		this.bufferedImage = bufferedImage;
		this.depthBuffer = depthBuffer;
	}
	
	public void paintPixel(int x, int y, Color color, float depth) {
		if( x>= 0 && x < bufferedImage.getWidth() &&
			y>= 0 && y < bufferedImage.getHeight()) {
			
			if(depth < depthBuffer[x][y]) {
				bufferedImage.setRGB(x, y, color.getRGB());
				depthBuffer[x][y] = depth;
			}
					
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
				
				float fx = (float) x;
				float fy = (float) y;
				
				if(PointInTriangle.isInside(a, b, c, fx, fy)) {
					float[] weights = PointInTriangle.getBarycentricCoordinates(a, b, c, fx, fy);
					float interpolatedZ = weights[0] * tri.getZ_a() +
							              weights[1] * tri.getZ_b() +
							              weights[2] * tri.getZ_c();
							
					paintPixel(x, y, color, interpolatedZ);
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
