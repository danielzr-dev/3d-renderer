package graphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Triangle;

public class RenderPanel extends JPanel {
	
	private TriangleRasterizer rasterizer;
	private List<Triangle> triangles;
	private BufferedImage bufferedImage;

	
	public RenderPanel(int width, int height) {
		this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.rasterizer = new TriangleRasterizer(bufferedImage);
		this.triangles= new ArrayList<>();
		
		setPreferredSize(new java.awt.Dimension(width, height));
	}
	
	public void addTriangle(Triangle triangle) {
		triangles.add(triangle);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Triangle  tri: triangles) {
			rasterizer.paintTriangle(tri);
		}
		
		g.drawImage(bufferedImage, 0, 0, null);
	}
	
}
