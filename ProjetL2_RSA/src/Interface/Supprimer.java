/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Component;
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


/**
 *
 * @author Soda Ndiaye
 */
public class Supprimer  extends JPanel{
    private JPanel jpan, jpan1, jpan2;
	
    private JButton[] jbt = new JButton[3];
	private JLabel jlab ;
	private JTextField jtf ;
	
	GridLayout grdl = new GridLayout(1, 2, 3, 3);
        
        public  Supprimer(){
        super();
		this.setSize(150, 150);
		jlab =new JLabel("Identifiant");
                jlab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                 jlab.setForeground(new java.awt.Color(255, 255, 255));
		jtf = new JTextField();
		jpan = new JPanel();
		jpan.setBackground(new java.awt.Color(176, 224, 230));
                jpan1 = new JPanel();
                jpan1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Supprimer un utilisateur ", 0, 0,  new Font("Dialog", 1, 16), new java.awt.Color(18, 8, 94)));
		jpan1.setLayout(grdl);
		jpan1.setBackground(new java.awt.Color(19, 191, 225));
		
		jpan1.setSize(300, 400);
		jpan1.add(jlab);jpan1.add(jtf);
		
		jlab.setPreferredSize(new Dimension(100, 30));
		jtf.setPreferredSize(new Dimension(200, 30));
              
		jbt[0] = new JButton("Annuler");
		jbt[1] = new JButton("Valider");
		
		jbt[2] = new JButton("Retour");
		jbt[2].setVisible(false);
		jbt[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActionPerformed(evt);
            }
        });
		
		
		jbt[1].addActionListener(new SupprimerUser());
		
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
	
	class SupprimerUser implements ActionListener {

        public void actionPerformed(ActionEvent e){
            
            
            if(jtf.getText().isEmpty() ){
            
                  JOptionPane.showMessageDialog(null, "Veuillez renseignez les champs vides", "RSA", JOptionPane.ERROR_MESSAGE);
            }
            else{
                     Entité_et_fonction.Admin Ad=new  Entité_et_fonction.Admin();
                     Ad.supprimerUser(jtf.getText());
          
                      jtf.setText("");
                     
            }
        }
	}
	

	 private void jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		 Interface.Admin A = new Interface.Admin();
         this.setVisible(false);
         A.setVisible(true);
	    }//GEN-LAST:event_jButton6ActionPerformed

}
	
