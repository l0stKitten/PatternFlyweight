package Flyweight2;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Cliente2 extends JFrame{
	
	JButton dibujar;
	
	int anchoPantalla = 1750;
	int altoPantalla = 700;
	
	Color[] colores = {Color.decode("#A600FF"), Color.decode("#0070FF"), 
			Color.decode("#80FF00"), Color.decode("#FFFC1D"), Color.decode("#FF7102"),
			Color.decode("#FF0202"), Color.decode("#FF02AE")};
	
	
	private int getRandX(){ return (int)(Math.random()*anchoPantalla);}
	private int getRandY(){ return (int)(Math.random()*altoPantalla);}
	private int getDiametro() {return (int) ((Math.random()* 20)-10);}

	private Color getRandColor(){
		Random randomGenerator = new Random();
		int randInt = randomGenerator.nextInt(7);
		return colores[randInt];
	}

	
	public Cliente2() {
		
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
					Flyweight circulo = FlyweightFactory2.getCirculo(getRandColor());
					circulo.draw(g, getRandX(), getRandY(), getDiametro());

					/*Flyweight circulo = new Circulo(getRandColor());
					circulo.draw(g, getRandX(), getRandY(), getRandX());*/
				}
			
			long fin = System.currentTimeMillis();
			System.out.println("Tiempo de Duración " + (fin - comienzo) + " millisegundos");

		}
		
	});
		
		this.add(contentPane);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Cliente2();
	}
}
