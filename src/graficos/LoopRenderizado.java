package graficos;

public class LoopRenderizado implements Runnable {
	
	private RenderizarPanel miPanel; 
	private boolean estaRenderizando = true;
	
	public LoopRenderizado(RenderizarPanel miPanel) {
		this.miPanel = miPanel;
	}
	
	
	@Override
	public void run() {
		
		while(estaRenderizando) {
			miPanel.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				System.out.println("Se ha interrumpido el renderizado");
			}
		}
		
	}

	public void detener() {
		estaRenderizando = false;
	}

}
