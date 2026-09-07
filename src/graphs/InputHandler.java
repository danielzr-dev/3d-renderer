package graphs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import math.Direction3D;
import math.Quaternion;
import model.Cube;
import model.Pyramid;
import model.Tetrahedron;
import model.Octahedron;
import rendering.ModelRenderer;

public class InputHandler implements KeyListener {
	
	private Camera camera;
	private Set<Integer> keysPressed = new HashSet<>();
	private ModelRenderer modelRenderer;
	
	private static final float ROTATION_SPEED = 0.02f;
	private static final float CUBE_ROTATION_SPEED = 0.02f;
	
	
	public InputHandler(Camera camera, ModelRenderer modelRenderer) {
		this.camera = camera;
		this.modelRenderer = modelRenderer;
		
	}
	
	
	public interface CubeController {
		void rotateCube(float dx, float dy, float dz);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keysPressed.add(e.getKeyCode());
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_C:
				modelRenderer.setActiveModel(new Cube());
				System.out.println("MODELO: CUBE");
				break;
			case KeyEvent.VK_P:
				modelRenderer.setActiveModel(new Pyramid());
				System.out.println("MODEL: PYRAMID");
				break;
				
			case KeyEvent.VK_T:
				modelRenderer.setActiveModel(new Tetrahedron());
				System.out.println("MODEL: TETRAHEDRON");
				break;
			
			case KeyEvent.VK_O:
				modelRenderer.setActiveModel(new Octahedron());
				System.out.println("MODEL: TETRAHEDRON");
				break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysPressed.remove(e.getKeyCode());
		
	}
	
	public void update() {
		
		float rotationSpeed = 0.03f;
		
		if(keysPressed.contains(KeyEvent.VK_W)) {
			//Rotate over left Y axis
			Direction3D xAxis = new Direction3D(1, 0, 0);
			Quaternion rotation = new Quaternion(rotationSpeed, xAxis);
			camera.rotate(rotation);
		}
		if(keysPressed.contains(KeyEvent.VK_S)){
			//Rotate over rigth Y axis
			Direction3D xAxis = new Direction3D(1, 0, 0);
			Quaternion rotation = new Quaternion(-rotationSpeed, xAxis);
			camera.rotate(rotation);
		}
		if(keysPressed.contains(KeyEvent.VK_A)) {
			//Rotate over X(up)
			Direction3D yAxis = new Direction3D(0, 1, 0);
			Quaternion rotation = new Quaternion(rotationSpeed, yAxis);
			camera.rotate(rotation);
		}
		if(keysPressed.contains(KeyEvent.VK_D)) {
			//Rotate over X(down)
			Direction3D yAxis = new Direction3D(0, 1, 0);
			Quaternion rotation = new Quaternion(-rotationSpeed, yAxis);
			camera.rotate(rotation);
			
		}	
		
		if(keysPressed.contains(KeyEvent.VK_UP)) {
			//Moves camera forward
			camera.move(0,0, -0.1f);
		}
		if(keysPressed.contains(KeyEvent.VK_DOWN)){
			//Moves camera backwards
			camera.move(0,0, 0.1f);
		}
		if(keysPressed.contains(KeyEvent.VK_LEFT)) {
			//Moves camera to the left
			camera.move(-0.1f, 0, 0);
		}
		if(keysPressed.contains(KeyEvent.VK_RIGHT)) {
			//Moves camera to the right
			camera.move(0.1f, 0, 0);
			
		}	
		
		if(keysPressed.contains(KeyEvent.VK_E)) {
	        modelRenderer.updateRotation(rotationSpeed, 0, 0);
	    }
	    if(keysPressed.contains(KeyEvent.VK_Q)) {
	        modelRenderer.updateRotation(-rotationSpeed, 0, 0);
	    }
	    if(keysPressed.contains(KeyEvent.VK_R)) {
	        modelRenderer.updateRotation(0, rotationSpeed, 0); 
	    }
	    if(keysPressed.contains(KeyEvent.VK_F)) {
	        modelRenderer.updateRotation(0, -rotationSpeed, 0);
	    }
	    

	}
	
	 
}
