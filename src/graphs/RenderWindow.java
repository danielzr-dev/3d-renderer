package graphs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;

import graphs.InputHandler.CubeController;
import math.Direction3D;
import math.Matrix4by4;
import math.Quaternion;
import math.Transformations;
import math.Vertex3D;
import model.Cube;
import model.Model3D;
import model.Triangle3D;
import rendering.ModelRenderer;


public class RenderWindow {

	private JFrame myFrame;
	private RenderPanel renderPanel;
	private RenderLoop loopRender;
	private Camera camera;
	private ModelRenderer modelRenderer;
	
	public RenderWindow() {
		
		this.myFrame = new JFrame("Renderizador 3D");
		this.renderPanel = new RenderPanel(1980, 1080);
		
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
		
		
		Model3D cube = new Cube();
		this.modelRenderer = new ModelRenderer(cube);
		
		InputHandler inputHandler = new InputHandler(camera, renderPanel);
		this.myFrame.addKeyListener(inputHandler);
		this.myFrame.setFocusable(true);
		
		this.loopRender = new RenderLoop(renderPanel, inputHandler);
		
		//Adding to panel
		this.renderPanel.setCamera(camera);
		this.renderPanel.setMatrices(modelMatrix,projectionMatrix);
		this.renderPanel.setModelRenderer(modelRenderer);
		
		this.loopRender = new RenderLoop(renderPanel, inputHandler);
	
		Thread thread = new Thread(loopRender);
		thread.start();
		
	}

}