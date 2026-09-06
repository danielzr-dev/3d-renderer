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
import model.Model3D;
import model.Triangle2D;
import model.Triangle3D;
import rendering.TriangleRasterizer;
import rendering.ModelRenderer;
import rendering.TransformPipeline;


public class RenderPanel extends JPanel implements InputHandler.CubeController{
	
	private TriangleRasterizer rasterizer;
	private List<Triangle2D> triangles;
	private BufferedImage bufferedImage;
	private List<Triangle3D> triangles3D;
	private Camera camera;
	private float[][] depthBuffer;
	private ModelRenderer modelRenderer;
	private Matrix4by4 modelMatrix;
	private Matrix4by4 projectionMatrix;
	

	
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
	
	public void setModelRenderer(ModelRenderer modelRenderer) {
		this.modelRenderer = modelRenderer;
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
			
			Matrix4by4 modelTransform = modelRenderer.getTransformMatrix();
			
			Matrix4by4 viewMatrix = camera.getViewMatrix();
			
			TransformPipeline pipeline = new TransformPipeline(
					modelMatrix,
					viewMatrix,
					projectionMatrix
			);
			
			Model3D activeModel = modelRenderer.getActiveModel();
			
			if(activeModel != null ) {
				List<Triangle3D> modelTriangles = activeModel.getTriangles();
				
				for(Triangle3D cubeTri: activeModel.getTriangles()) {
					
					if(!cubeTri.isFrontFacing(camera.getPosition())) {
						continue;
					}
					
					Vertex v1 = pipeline.transformVertex(cubeTri.getA(), modelTransform, getWidth(), getHeight());
					Vertex v2 = pipeline.transformVertex(cubeTri.getB(), modelTransform, getWidth(), getHeight());
					Vertex v3 = pipeline.transformVertex(cubeTri.getC(), modelTransform, getWidth(), getHeight());
					
					Triangle2D tri2D = new Triangle2D(v1, v2, v3, cubeTri.getColor(),
													  v1.getZ(), v2.getZ(), v3.getZ());
					
					//Valid triangles check
					if(!isValidVertex(v1) || !isValidVertex(v2) || !isValidVertex(v3)) {
						continue;
					}
					
					rasterizer.paintTriangle(tri2D);
				}
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
	
	
	private boolean isValidVertex(Vertex v) {
		return !Float.isNaN(v.getX()) && !Float.isNaN(v.getY());
	}

	@Override
	public void rotateCube(float dx, float dy, float dz) {
		modelRenderer.updateRotation(dx, dy, dz);
		
	}
	
	
}
