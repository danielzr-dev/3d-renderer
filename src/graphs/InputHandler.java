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
	
	public InputHandler(Camera camera) {
		this.camera = camera;
		
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
	}

}
