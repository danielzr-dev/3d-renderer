package graphs;

public class RenderLoop implements Runnable {
	
	private RenderPanel myPanel; 
	private boolean isRendering = true;
	private InputHandler inputHandler;
	
	public RenderLoop(RenderPanel miPanel, InputHandler inputHandler) {
		this.myPanel = miPanel;
		this.inputHandler = inputHandler;
	}
	
	@Override
	public void run() {
		
		while(isRendering) {
			inputHandler.update();
			
			myPanel.updateCubeRotation(0.00f, 0.03f, 0.0f); //X and Y rotation
			
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
