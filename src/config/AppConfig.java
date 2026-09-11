package config;

public final class AppConfig {
	
	//Window configuration
	public static final int WINDOW_WIDTH = 1980;
	public static final int WINDOW_HEIGHT = 1080;

	//Camera configuration
	public static final float FOV = 45.0f;
	public static final float NEAR_PLANE = 0.1f;
	public static final float FAR_PLANE = 100.0f;
	
	//Initial camera position
	public static final float CAMERA_INIT_X = 0;
	public static final float CAMERA_INIT_Y = 0;
	public static final float CAMERA_INIT_Z = 5;
	
	//Rotation speeds
	public static final float ROTATION_SPEED = 0.03f;
	public static final float CAMERA_MOVE_SPEED = 0.1f;
	
	//Wireframe rendering color
	public static final java.awt.Color WIREFRAME_COLOR = java.awt.Color.GREEN;
	
}
