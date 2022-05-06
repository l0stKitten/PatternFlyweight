package Flyweight;

import java.util.HashMap;
import java.awt.Color;

public class FlyweightFactory {
	private static final HashMap<Color, Rectangulo> rectanguloUni = new HashMap<Color, Rectangulo>();
	
	public static Rectangulo getRect(Color color) {
		Rectangulo rect = (Rectangulo)rectanguloUni.get(color);

		if(rect == null) {
			rect = new Rectangulo(color);
			rectanguloUni.put(color, rect);
			System.out.println("Rect�ngulo creado del color : " + color);
		}
		
		return rect;
	}

}
