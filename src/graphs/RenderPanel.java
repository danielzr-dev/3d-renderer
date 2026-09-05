package graphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import math.Direction3D;
import math.Matrix4by4;
import math.Transformations;
import math.Vertex;
import model.Triangle2D;
import model.Triangle3D;
import rendering.TriangleRasterizer;
import rendering.TransformPipeline;


public class RenderPanel extends JPanel implements InputHandler.CubeController{
	
	private TriangleRasterizer rasterizer;
	private List<Triangle2D> triangles;
	private BufferedImage bufferedImage;
	private List<Triangle3D> triangles3D;
	private Matrix4by4 modelMatrix;
	private Matrix4by4 projectionMatrix;
	private Matrix4by4 cubeTransformMatrix = new Matrix4by4();
	private List<Triangle3D> cubeTriangles = new ArrayList<>();
	private Camera camera;
	private float[][] depthBuffer;
	
	private float cubeRotationX = 0.0f;
	private float cubeRotationY = 0.0f;
	private float cubeRotationZ = 0.0f;

	
	public RenderPanel(int width, int height) {
		this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.depthBuffer = new float[width][height];
		this.rasterizer = new TriangleRasterizer(bufferedImage, depthBuffer);
		this.triangles= new ArrayList<>();
		this.triangles3D = new ArrayList<>();
		
		for(int y =0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				depthBuffer[x][y] = Float.MAX_VALUE;
			}
		}
		
		setPreferredSize(new java.awt.Dimension(width, height));
	}
	
	public void addTriangle(Triangle2D triangle) {
		triangles.add(triangle);
	}
	
	public void addTriangle(Triangle3D triangle) {
		triangles3D.add(triangle);
	}
	
	public void addCubeTriangle(Triangle3D triangle) {
		cubeTriangles.add(triangle);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Clear buffer
		Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
		g2d.dispose();
		
		for(int y = 0; y < bufferedImage.getHeight(); y++) {
			for(int x = 0; x < bufferedImage.getWidth();	 x++) {
				depthBuffer[x][y] = Float.MAX_VALUE;
			}
		}
		
		
		//Pipeline for vertex transformation 3D -> 2D
		
		if(camera != null && modelMatrix != null && projectionMatrix != null) {
			Matrix4by4 viewMatrix = camera.getViewMatrix();
			TransformPipeline pipeline = new TransformPipeline(modelMatrix, viewMatrix
					, projectionMatrix);
			
			
			updateCubeTransformMatrix();
			
			//Cube triangles
			for(Triangle3D cubeTri: cubeTriangles) {
				
				if(!cubeTri.isFrontFacing(camera.getPosition())) {
					continue;
				}
				
				Vertex v1 = pipeline.transformVertex(cubeTri.getA(), cubeTransformMatrix, getWidth(), getHeight());
				Vertex v2 = pipeline.transformVertex(cubeTri.getB(), cubeTransformMatrix, getWidth(), getHeight());
				Vertex v3 = pipeline.transformVertex(cubeTri.getC(), cubeTransformMatrix, getWidth(), getHeight());
				
				Triangle2D tri2D = new Triangle2D(v1, v2, v3, cubeTri.getColor(),
												  v1.getZ(), v2.getZ(), v3.getZ());
				
				//Valid triangles check
				if(!isValidVertex(v1) || !isValidVertex(v2) || !isValidVertex(v3)) {
					continue;
				}
				
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
	
	public void updateCubeRotation(float deltaX, float deltaY, float deltaZ) {
		cubeRotationX += deltaX;
		cubeRotationY += deltaY;
		cubeRotationZ += deltaZ;
		
	}
	
	private void updateCubeTransformMatrix() {
		Direction3D xAxis = new Direction3D(1,0,0);
		Direction3D yAxis = new Direction3D(0,1,0);
		Direction3D zAxis = new Direction3D(0,0,1);
		
		Matrix4by4 rotaX = Transformations.rotation(cubeRotationX, xAxis);
		Matrix4by4 rotaY = Transformations.rotation(cubeRotationY, yAxis);
		Matrix4by4 rotaZ = Transformations.rotation(cubeRotationZ, zAxis);
		
		cubeTransformMatrix = rotaX.multiply(rotaY).multiply(rotaZ);
	}
	
	private boolean isValidVertex(Vertex v) {
		return !Float.isNaN(v.getX()) && !Float.isNaN(v.getY());
	}

	@Override
	public void rotateCube(float dx, float dy, float dz) {
		updateCubeRotation(dx, dy, dz);
		
	}
	
	
}
