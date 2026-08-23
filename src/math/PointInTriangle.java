package math;


public class PointInTriangle {

	
	public static boolean isInside (Vertex a, Vertex b, Vertex c, Vertex p) {

		double denominator = ((b.y - c.y) * (a.x - c.x) + 
						   (c.x - b.x) * (a.y - c.y));
		
		double vertexA = ((b.y - c.y) * (p.x - c.x) +
					(c.x - b.x) * (p.y - c.y)) / denominator;
		
		double vertexB  = ((c.y - a.y) * (p.x - c.x) +
				    (a.x - c.x) * (p.y - c.y)) / denominator;
		
		double vertexC = 1 - vertexA - vertexB;
		
		return (vertexA >=0 && vertexB >= 0 && vertexC>= 0);
	}
	
	public static boolean isInside(Vertex A, Vertex B, Vertex C, 
			double px, double py ) {
		Vertex P = new Vertex(px, py);
		return isInside(A, B, C, P);
	}
	
//	public static void main(String[] args) {
//		
//		Vertice a = new Vertice(0,0);
//		Vertice b = new Vertice(10, 30);
//		Vertice c = new Vertice(20, 0);
//		Vertice p = new Vertice(10, 15);
//		
//		String resultado = estaDentro(a, b, c, p);
//		
//		System.out.println(resultado);
// 		 
//	}

}
