package graphs;

import java.awt.Color;

import javax.swing.JFrame;

import math.Vertex;
import model.Triangle2D;

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
		
		Vertex v1 = new Vertex(100, 100);
		Vertex v2 = new Vertex(400, 150);
		Vertex v3 = new Vertex(250, 400);
		Triangle2D tri = new Triangle2D(v1, v2, v3, Color.RED);
		this.renderPanel.addTriangle(tri);
		
		Thread thread = new Thread(loopRender);
		thread.start();
		
	}
	
}