package math;


public class PointInTriangle {

	
	public static boolean isInside (Vertex a, Vertex b, Vertex c, Vertex p) {

		float denominator = ((b.getY() - c.getY()) * (a.getX() - c.getX()) + 
						   (c.getX() - b.getX()) * (a.getY() - c.getY()));
		
		float vertexA = ((b.getY() - c.getY()) * (p.getX() - c.getX()) +
					(c.getX() - b.getX()) * (p.getY() - c.getY())) / denominator;
		
		float vertexB  = ((c.getY() - a.getY()) * (p.getX() - c.getX()) +
				    (a.getX() - c.getX()) * (p.getY() - c.getY())) / denominator;
		
		float vertexC = 1 - vertexA - vertexB;
		
		return (vertexA >=0 && vertexB >= 0 && vertexC>= 0);
		
	}
	
	public static boolean isInside(Vertex A, Vertex B, Vertex C, 
			float px, float py ) {
		Vertex P = new Vertex(px, py);
		return isInside(A, B, C, P);
	}
	
}
