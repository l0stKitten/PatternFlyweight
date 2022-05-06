package Flyweight2;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo implements Flyweight{
	private Color color;
	
	public Circulo(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Graphics panel, int x, int y, int ancho) {
		panel.setColor(color);
		panel.fillOval(x, y, ancho, ancho);
		
	}
	
}