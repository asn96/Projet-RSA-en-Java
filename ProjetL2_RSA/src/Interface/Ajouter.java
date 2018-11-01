/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Entité_et_fonction.Admin;
//import jdk.internal.org.objectweb.asm.tree.analysis.Frame;
/**
 *
 * @author Soda Ndiaye
 */
public class Ajouter  extends JPanel{
    private JPanel jpan, jpan1, jpan2;
	private Gestion_Utilisateurs usergestion;
    private JButton[] jbt = new JButton[3];
	private JLabel[] jlab = new JLabel[5]; 
	private JTextField[] jtf = new JTextField[5];
	
	
	GridLayout grdl = new GridLayout(5, 2, 3, 3);
        
        public  Ajouter(){
        super();
		this.setSize(150, 150);
		jlab[0] = new JLabel();
		jlab[1] = new JLabel();
		jlab[2] = new JLabel();
		jlab[3] = new JLabel();
		jlab[4] =new JLabel();
                
		jlab[0].setText("Identifiant");
		jlab[2].setText("Prénom");
		jlab[1].setText("Nom");
                jlab[3].setText("Mot de passe ");
                jlab[4].setText("Statut");
                for (int i = 0; i < jlab.length; i++) {
                    
                        jlab[i].setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                        jlab[i].setForeground(new java.awt.Color(255, 255, 255));
            }
                
		jtf[0] = new JTextField();
		jtf[1] = new JTextField();
		jtf[2] = new JTextField();
		jtf[3] = new JTextField();
        jtf[4] = new JTextField();
        jtf[4].setText("User");
                
		jpan = new JPanel();
		jpan.setBackground(new java.awt.Color(176, 224, 230));
                jpan1 = new JPanel();
                jpan1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ajouter un utilisateur ", 0, 0,  new Font("Dialog", 1, 16), new java.awt.Color(18, 8, 94)));
		jpan1.setLayout(grdl);
		jpan1.setBackground(new java.awt.Color(19, 191, 225));
		
		jpan1.setSize(300, 400);
		jpan1.add(jlab[0]);jpan1.add(jtf[0]);
		jpan1.add(jlab[1]);jpan1.add(jtf[1]);
		jpan1.add(jlab[2]);jpan1.add(jtf[2]);
        jpan1.add(jlab[4]);jpan1.add(jtf[4]);
		jpan1.add(jlab[3]);jpan1.add(jtf[3]);
		
		
		for(int i=0; i<jlab.length; i++)
		{
			jlab[i].setPreferredSize(new Dimension(100, 30));
			jtf[i].setPreferredSize(new Dimension(200, 30));
		}
		jbt[0] = new JButton("Annuler");
		jbt[1] = new JButton("Valider");
		
		jbt[1].addActionListener(new AjouterUser());
		
		jbt[2] = new JButton("Retour");
		jbt[2].setVisible(false);
		jbt[2].addActionListener(new Retour());
		
		jpan2 = new JPanel();
		jpan2.add(jbt[0]);jpan2.add(jbt[1]);jpan2.add(jbt[2]);
		
		jpan.add(jpan1);jpan.add(jpan2);
		
	}

	public JPanel getJpan() {
		return jpan;
	}

	public void setJpan(JPanel jpan) {
		this.jpan = jpan;
	}

   
	
	
	class AjouterUser implements ActionListener {

        public void actionPerformed(ActionEvent e){
            
            
            if(jtf[0].getText().isEmpty() || jtf[1].getText().isEmpty() || jtf[2].getText().isEmpty() || jtf[3].getText().isEmpty() || jtf[4].getText().isEmpty() ){
            
                  JOptionPane.showMessageDialog(null, "Veuillez renseignez les champs vides", "RSA", JOptionPane.ERROR_MESSAGE);
            }
            else{
            
                     Admin Ad=new  Admin();
                     Ad.ajouterUser(jtf[0].getText() ,jtf[1].getText() , jtf[2].getText(), jtf[3].getText(),jtf[4].getText());
          
                    for (int i = 0; i < jtf.length; i++) {
                         jtf[i].setText("");
                     }

                   
            }
        }
	}
	
	class Retour implements ActionListener {

        public void actionPerformed(ActionEvent e){
            Interface.Admin A = new Interface.Admin();
            setVisible(false);
            A.setVisible(true);
            
            }
        }
	
}
	
