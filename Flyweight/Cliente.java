package Flyweight;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Cliente extends JFrame{
	
	JButton dibujar;
	
	int anchoPantalla = 1750;
	int altoPantalla = 700;
	
	Color[] colores = {Color.decode("#005ABF"), Color.decode("#EE2828"), 
			Color.decode("#FFFFFF"), Color.decode("#131313"), Color.decode("#FFF700")};
	
	
	private int getRandX(){ return (int)(Math.random()*anchoPantalla); }
	private int getRandY(){ return (int)(Math.random()*altoPantalla); }

	private Color getRandColor(){
		Random randomGenerator = new Random();
		int randInt = randomGenerator.nextInt(5);
		return colores[randInt];
	}

	
	public Cliente() {
		
		this.setSize(anchoPantalla,altoPantalla);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Flyweight Prueba");

		JPanel contentPane = new JPanel();

		contentPane.setLayout(new BorderLayout());

		final JPanel  drawingPanel  = new JPanel();
		dibujar = new JButton("Componer");
		contentPane.add(drawingPanel,  BorderLayout.CENTER);
		contentPane.add(dibujar, BorderLayout.SOUTH);
		
		
		dibujar.addActionListener(new ActionListener() {
			
			
		public void actionPerformed(ActionEvent event) {
			Graphics g = drawingPanel.getGraphics();
			long comienzo = System.currentTimeMillis();
			
				for(int i=0; i < 10000; ++i) {
					Flyweight rect = FlyweightFactory.getRect(getRandColor());
					rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
				}
			
			long fin = System.currentTimeMillis();
			System.out.println("Tiempo de Duración " + (fin - comienzo) + " millisegundos");

		}
		
	});
		
		this.add(contentPane);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Cliente();
	}
}
