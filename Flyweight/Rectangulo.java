package Flyweight;

import java.awt.*;

public class Rectangulo implements Flyweight{
	private Color color;
	
	public Rectangulo(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Graphics panel, int supe_I, int supe_D, int inf_I, int inf_D) {
		panel.setColor(color);
		panel.fillRect(supe_I, supe_D, inf_I, inf_D);
		
	}
	
}
