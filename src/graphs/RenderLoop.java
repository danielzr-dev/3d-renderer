package graphs;

public class RenderLoop implements Runnable {
	
	private RenderPanel miPanel; 
	private boolean isRendering = true;
	
	public RenderLoop(RenderPanel miPanel) {
		this.miPanel = miPanel;
	}
	
	@Override
	public void run() {
		
		while(isRendering) {
			miPanel.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				System.out.println("Renderer has stopped");
			}
		}
		
	}

	public void stop() {
		isRendering = false;
	}

}
