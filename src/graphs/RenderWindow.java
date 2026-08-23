package graphs;

import javax.swing.JFrame;

public class RenderWindow {

	private JFrame myFrame;
	private RenderPanel render;
	private RenderLoop loopRender;

	public RenderWindow() {
		
		this.myFrame = new JFrame("Renderizador 3D");
		this.render = new RenderPanel(1980, 1080);
		this.loopRender = new RenderLoop(render);
		
		this.myFrame.add(this.render);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFrame.pack();
		this.myFrame.setVisible(true);
		
		Thread thread = new Thread(loopRender);
		thread.start();
		
	}
	
}