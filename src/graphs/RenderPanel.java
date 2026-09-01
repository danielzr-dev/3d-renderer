package graphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import math.Matrix4by4;
import math.Vertex;
import model.Triangle2D;
import model.Triangle3D;
import rendering.TriangleRasterizer;
import rendering.TransformPipeline;


public class RenderPanel extends JPanel {
	
	private TriangleRasterizer rasterizer;
	private List<Triangle2D> triangles;
	private BufferedImage bufferedImage;
	private List<Triangle3D> triangles3D;
	private Matrix4by4 modelMatrix;
	private Matrix4by4 projectionMatrix;
	private Camera camera;

	
	public RenderPanel(int width, int height) {
		this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.rasterizer = new TriangleRasterizer(bufferedImage);
		this.triangles= new ArrayList<>();
		this.triangles3D = new ArrayList<>();
		
		setPreferredSize(new java.awt.Dimension(width, height));
	}
	
	public void addTriangle(Triangle2D triangle) {
		triangles.add(triangle);
	}
	
	public void addTriangle(Triangle3D triangle) {
		triangles3D.add(triangle);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Clear buffer
		Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
		g2d.dispose();
		
		//Pipeline for vertex transformation 3D -> 2D
		
		if(camera != null && modelMatrix != null && projectionMatrix != null) {
			Matrix4by4 viewMatrix = camera.getViewMatrix();
			TransformPipeline pipeline = new TransformPipeline(modelMatrix, viewMatrix
					, projectionMatrix);
			
			//3D Triangles transform
			for(Triangle3D tri3D : triangles3D) {
				Vertex v1 = pipeline.transformVertex(tri3D.getA(), getWidth(), getHeight());
				Vertex v2 = pipeline.transformVertex(tri3D.getB(), getWidth(), getHeight());
				Vertex v3 = pipeline.transformVertex(tri3D.getC(), getWidth(), getHeight());
				
				Triangle2D tri2D = new Triangle2D(v1, v2, v3, tri3D.getColor());
				rasterizer.paintTriangle(tri2D);
				
			}
			
		}
		
		for(Triangle2D  tri: triangles) {
			rasterizer.paintTriangle(tri);
		}
		

		g.drawImage(bufferedImage, 0, 0, null);
	}
	
	public void setMatrices(Matrix4by4 model, Matrix4by4 projection) {
		this.modelMatrix = model;
		this.projectionMatrix = projection;
		
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
		
	}
	
	
}
