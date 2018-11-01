/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tête extends JPanel {
	
	private JPanel panel1;
	private JLabel jlab1, jlab2, jlab3; 
	private ImageIcon img ;
	
	
	

	public JPanel getPanel1() {
		return panel1;
	}




	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}




	public Tête() {
		super();
		
		//Initialisation
		
		img = new ImageIcon("images\\labo.jpg");
		panel1 = new JPanel();
		panel1.setBackground(new java.awt.Color(19, 191, 225));
		panel1.setLayout(new FlowLayout());
		
		jlab1 = new JLabel();
		jlab1.setBounds(10, 10, 100, 70);
		//jlab1.setIcon(img);
		
		jlab2 = new JLabel("GESTION DES UTILISATEURS");
		Font police = new Font("tahoma", 5, 20);
		jlab2.setFont(police);
		jlab2.setBackground(new java.awt.Color(176, 224, 230));
		
		jlab3 = new JLabel();
		jlab3.setBounds(10, 10, 100, 70);
		//jlab3.setIcon(img);
		
		panel1.add(jlab1);
		panel1.add(jlab2);
		panel1.add(jlab3);
		
		
		
	}




	

}

