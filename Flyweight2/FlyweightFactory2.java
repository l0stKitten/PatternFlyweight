package Flyweight2;

import java.util.HashMap;
import java.awt.Color;

public class FlyweightFactory2 {
	private static final HashMap<Color, Circulo> circuloUni = new HashMap<Color, Circulo>();
	
	public static Circulo getCirculo(Color color) {
		Circulo rect = (Circulo)circuloUni.get(color);

		if(rect == null) {
			rect = new Circulo(color);
			circuloUni.put(color, rect);
			System.out.println("Círculo creado del color : " + color);
		}
		
		return rect;
	}

}
