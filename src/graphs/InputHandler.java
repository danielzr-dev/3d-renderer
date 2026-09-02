package graphs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import math.Direction3D;
import math.Quaternion;

public class InputHandler implements KeyListener {
	
	private Camera camera;
	
	public InputHandler(Camera camera) {
		this.camera = camera;
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		float rotationSpeed = 5.0f;
		
		if(key == KeyEvent.VK_W) {
			//Rotate over left Y axis
			Direction3D yAxis = new Direction3D(0, 1, 0);
			Quaternion rotation = new Quaternion(rotationSpeed, yAxis);
			camera.rotate(rotation);
		}
		else if(key == KeyEvent.VK_S){
			//Rotate over rigth Y axis
			Direction3D yAxis = new Direction3D(0, 1, 0);
			Quaternion rotation = new Quaternion(-rotationSpeed, yAxis);
			camera.rotate(rotation);
		}
		else if(key == KeyEvent.VK_A) {
			//Rotate over X(up)
			Direction3D xAxis = new Direction3D(1, 0, 0);
			Quaternion rotation = new Quaternion(rotationSpeed, xAxis);
			camera.rotate(rotation);
		}
		else if(key == KeyEvent.VK_D) {
			//Rotate over X(down)
			Direction3D xAxis = new Direction3D(1, 0, 0);
			Quaternion rotation = new Quaternion(-rotationSpeed, xAxis);
			camera.rotate(rotation);
		}	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
