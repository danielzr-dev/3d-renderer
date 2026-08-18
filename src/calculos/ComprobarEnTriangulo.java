package calculos;


public class ComprobarEnTriangulo {

	
	public static String estaDentro (Vertice a, Vertice b, Vertice c, Vertice p) {

		double denominador = ((b.y-c.y) * (a.x-c.x) + 
						   (c.x - b.x) * (a.y - c.y));
		
		double verticeA = ((b.y - c.y) * (p.x - c.x) +
					(c.x - b.x) * (p.y - c.y)) / denominador;
		
		double verticeB  = ((c.y - a.y) * (p.x - c.x) +
				    (a.x - c.x) * (p.y - c.y)) / denominador;
		
		double verticeC = 1 - verticeA - verticeB;
		
		if( verticeA >=0 && verticeB >= 0 && verticeC>= 0) {
			return "Está dentro";
		} else {
			return "Está fuera";
		}
		
	}
	
	public static String estaDentro(Vertice A, Vertice B, Vertice C, 
			double px, double py ) {
		Vertice P = new Vertice(px, py);
		return estaDentro(A, B, C, P);
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
