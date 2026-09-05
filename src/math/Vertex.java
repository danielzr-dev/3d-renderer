package math;

public class Vertex {
	
	private float x;
	private float y;
	private float z;
	
	public Vertex (float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vertex(float x, float y) {
		this(x, y, 0.0f);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
}
