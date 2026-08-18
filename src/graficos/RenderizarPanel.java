package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import calculos.ComprobarEnTriangulo;
import calculos.Vertice;
import modelo.Triangulo;

public class RenderizarPanel extends JPanel {
	
	BufferedImage buffimg;
	
	public RenderizarPanel(int ancho, int alto) {
		
		buffimg = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		setPreferredSize(new java.awt.Dimension(ancho, alto));
		
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffimg, 0, 0, null);
		
	}
	
	public void pintarPixel(int x, int y, Color color) {
		buffimg.setRGB(x, y, color.getRGB());
	}
	
	
	public void pintarTriangulo(Triangulo tri) {
		
		Vertice a = tri.getA();
		Vertice b = tri.getB();
		Vertice c = tri.getC();
		Color color = tri.getColor();
		
		int[] delimTriangulo = calcularDelimitacion(tri);
		int minX = delimTriangulo[0];
		int maxX = delimTriangulo[1];
		int minY = delimTriangulo[2];
		int maxY = delimTriangulo[3];
		
		for(int y = minY; y <= maxY; y++) {
			for(int x = minX; x<= maxX; x++) {
				if(ComprobarEnTriangulo.estaDentro(a, b, c, x, y).equals("Esta dentro")) {
					pintarPixel(x, y, color);
				}
			}
		}
		
	}
	
	private int[] calcularDelimitacion(Triangulo tri) {
		double maxX = Math.max(tri.getA().getX(), Math.max(tri.getB().getX(), tri.getC().getX()));
		double minX = (int) Math.min(tri.getA().getX(), Math.min(tri.getB().getX(), tri.getC().getX()));
		double maxY = (int) Math.max(tri.getA().getY(), Math.max(tri.getB().getY(), tri.getC().getY()));
		double minY = (int) Math.min(tri.getA().getY(), Math.min(tri.getB().getY(), tri.getC().getY()));
		
		return new int[] {(int) minX, (int) maxX, (int) minY, (int) maxY};
	}

}
