package graphs;

import java.awt.Color;

import javax.swing.JFrame;

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
		
		Vertex3D a = new Vertex3D( 0.0f,  1.0f, 0.0f); 
		Vertex3D b = new Vertex3D(-1.0f, -1.0f, 0.0f); 
		Vertex3D c = new Vertex3D( 1.0f, -1.0f, 0.0f); 
		
		Triangle3D tri3D = new Triangle3D(a, b, c, Color.RED);
		
		this.renderPanel.addTriangle(tri3D);
	
	  /*Vertex v1 = new Vertex(100, 100);
	  Vertex v2 = new Vertex(400, 150);
	  Vertex v3= new Vertex(250, 400); Triangle2D tri = new Triangle2D(v1, v2, v3,
	  Color.RED); this.renderPanel.addTriangle(tri);*/

		Thread thread = new Thread(loopRender);
		thread.start();
		
	}
	
}