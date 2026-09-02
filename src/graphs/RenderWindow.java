package graphs;

import java.awt.Color;

import javax.swing.JFrame;

import math.Direction3D;
import math.Matrix4by4;
import math.Quaternion;
import math.Transformations;
import math.Vertex;
import math.Vertex3D;
import model.Triangle2D;
import model.Triangle3D;

public class RenderWindow {

	private JFrame myFrame;
	private RenderPanel renderPanel;
	private RenderLoop loopRender;


	public RenderWindow() {
		
		this.myFrame = new JFrame("Renderizador 3D");
		this.renderPanel = new RenderPanel(1980, 1080);
		this.loopRender = new RenderLoop(renderPanel);
		
		this.myFrame.add(this.renderPanel);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFrame.pack();
		this.myFrame.setVisible(true);
		
		//Matrices
		Matrix4by4 modelMatrix = new Matrix4by4();
		Matrix4by4 projectionMatrix = Transformations.perspective(
				45.0f, 1980.f/1080.0f, 0.1f, 100.f);
		
		//Camera
		Vertex3D cameraPosition = new Vertex3D(0, 0, 5);
		Quaternion cameraRotation = new Quaternion(0, 0, 0, 1); //Identity (without rotation
		Camera camera = new Camera(cameraPosition, cameraRotation);
		
		//Adding to panel
		this.renderPanel.setMatrices(modelMatrix,projectionMatrix);
		this.renderPanel.setCamera(camera);
		
		
		//Triangle 1 
		Vertex3D a = new Vertex3D( 0.0f,  1.0f, 0.0f); 
		Vertex3D b = new Vertex3D(-1.0f, -1.0f, 0.0f); 
		Vertex3D c = new Vertex3D( 1.0f, -1.0f, 0.0f); 
		Triangle3D tri3D = new Triangle3D(a, b, c, Color.RED);//(no rotation)
		this.renderPanel.addTriangle(tri3D);
		
		// Triangle 2 
		Vertex3D d = new Vertex3D(2.0f, 1.0f, 0.0f);
		Vertex3D e = new Vertex3D(1.0f, -1.0f, 0.0f);
		Vertex3D f = new Vertex3D(3.0f, -1.0f, 0.0f);
		
		
		//45 degree rotation
		Direction3D zAxis = new Direction3D(0, 0, 1);
		Matrix4by4 rota45 = Transformations.rotation(45.f, zAxis);
		Triangle3D tri2 = new Triangle3D(d, e, f, Color.BLUE, rota45);
		
		
		this.renderPanel.addTriangle(tri2);
		

	  /*Vertex v1 = new Vertex(100, 100);
	  Vertex v2 = new Vertex(400, 150);
	  Vertex v3= new Vertex(250, 400); Triangle2D tri = new Triangle2D(v1, v2, v3,
	  Color.RED); this.renderPanel.addTriangle(tri);*/

		Thread thread = new Thread(loopRender);
		thread.start();
		
	}
	
}