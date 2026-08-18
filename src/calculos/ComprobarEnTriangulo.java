package calculos;


public class ComprobarEnTriangulo {

	
	public static String estaDentro (Vertice A, Vertice B, Vertice C, Vertice P) {

		double denominador = ((B.y-C.y) * (A.x-C.x) + 
						   (C.x - B.x) * (A.y - C.y));
		
		double a = ((B.y - C.y) * (P.x - C.x) +
					(C.x - B.x) * (P.y - C.y)) / denominador;
		
		double b = ((C.y - A.y) * (P.x - C.x) +
				    (A.x - C.x) * (P.y - C.y)) / denominador;
		
		double c = 1 - a - b;
		
		if( a>=0 && b >= 0 && c>= 0) {
			return "Está dentro";
		} else {
			return "Está fuera";
		}
		
	}
	
	public static void main(String[] args) {
		
		Vertice a = new Vertice(0,0);
		Vertice b = new Vertice(10, 30);
		Vertice c = new Vertice(20, 0);
		Vertice p = new Vertice(10, 15);
		
		String resultado = estaDentro(a, b, c, p);
		
		System.out.println(resultado);
 		 
	}

}
