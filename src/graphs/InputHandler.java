package graphs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import math.Direction3D;
import math.Quaternion;

public class InputHandler implements KeyListener {
	
	private Camera camera;
	private Set<Integer> keysPressed = new HashSet<>();
	private CubeController cubeController;
	
	private static final float ROTATION_SPEED = 0.02f;
	private static final float CUBE_ROTATION_SPEED = 0.02f;
	
	
	public InputHandler(Camera camera, CubeController cubeController) {
		this.camera = camera;
		this.cubeController = cubeController;
		
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysPressed.remove(e.getKeyCode());
		
	}
	
	public void update() {
		
		float rotationSpeed = 0.01f;
		
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
	        cubeController.rotateCube(CUBE_ROTATION_SPEED, 0, 0);  // Rota eje X
	    }
	    if(keysPressed.contains(KeyEvent.VK_Q)) {
	        cubeController.rotateCube(-CUBE_ROTATION_SPEED, 0, 0);
	    }
	    if(keysPressed.contains(KeyEvent.VK_R)) {
	        cubeController.rotateCube(0, CUBE_ROTATION_SPEED, 0);  // Rota eje Y
	    }
	    if(keysPressed.contains(KeyEvent.VK_F)) {
	        cubeController.rotateCube(0, -CUBE_ROTATION_SPEED, 0);
	    }
		
		
	}

}
