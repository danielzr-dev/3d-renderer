package graficos;

import javax.swing.JFrame;

public class Ventana {

	private JFrame miFrame;
	private RenderizarPanel renderizado;
	private LoopRenderizado loopRender;

	public Ventana() {
		
		this.miFrame = new JFrame("Renderizador 3D");
		this.renderizado = new RenderizarPanel(1980, 1080);
		this.loopRender = new LoopRenderizado(renderizado);
		
		this.miFrame.add(this.renderizado);
		this.miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.miFrame.pack();
		this.miFrame.setVisible(true);
		
		Thread thread = new Thread(loopRender);
		thread.start();
		
	}
	
}