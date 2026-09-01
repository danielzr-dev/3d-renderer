package graphs;

public class RenderLoop implements Runnable {
	
	private RenderPanel myPanel; 
	private boolean isRendering = true;
	
	public RenderLoop(RenderPanel miPanel) {
		this.myPanel = miPanel;
	}
	
	@Override
	public void run() {
		
		while(isRendering) {
			myPanel.repaint();
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
