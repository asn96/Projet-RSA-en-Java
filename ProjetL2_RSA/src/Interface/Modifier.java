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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Soda Ndiaye
 */
public class Modifier   extends JPanel{
    private JPanel jpan, jpan1, jpan2;
    private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
     
     private static String user="root"; 
 
     private static String pass1="";
	
    private JButton[] jbt = new JButton[3];
	private JLabel[] jlab = new JLabel[3]; 
        private JComboBox Box ;
	private JTextField[] jtf = new JTextField[2];
	
	GridLayout grdl = new GridLayout(3, 2, 3, 3);
        
        public  Modifier(){
        super();
		this.setSize(150, 150);
		jlab[0] = new JLabel();
		jlab[1] = new JLabel();
		jlab[2] = new JLabel();
		jlab[0].setText("Identifiant");
		jlab[2].setText("Prénom");
		jlab[1].setText("Nom");
                for (int i = 0; i < jlab.length; i++) {
                    
                        jlab[i].setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
                        jlab[i].setForeground(new java.awt.Color(255, 255, 255));
            }
                
		jtf[0] = new JTextField();
		jtf[1] = new JTextField();
		Box =new JComboBox();
		jpan = new JPanel();
		jpan.setBackground(new java.awt.Color(176, 224, 230));
                jpan1 = new JPanel();
                jpan1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Modifier un utilisateur ", 0, 0,  new Font("Dialog", 1, 16), new java.awt.Color(18, 8, 94)));
		jpan1.setLayout(grdl);
		jpan1.setBackground(new java.awt.Color(19, 191, 225));
                
                 Box.setSelectedItem("");
                Box.addActionListener(new selection());
		try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            
            Connection c1 =DriverManager.getConnection(url, user, pass1);
            
            System.out.println("Connection bien etablie");
            
            String soc;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM utilisateur");
            
           while(b.next()){
                soc= b.getString("Id");
               Box.addItem(""+soc);
           }

            }catch(Exception ex){
            ex.printStackTrace();
            }
        
		
		jpan1.setSize(300, 400);
		jpan1.add(jlab[0]);jpan1.add(Box);
		jpan1.add(jlab[1]);jpan1.add(jtf[0]);
		jpan1.add(jlab[2]);jpan1.add(jtf[1]);
		
		for(int i=0; i<jtf.length; i++)
		{
			jtf[i].setPreferredSize(new Dimension(200, 30));
		}
		for(int i=0; i<jlab.length; i++)
		{
			jlab[i].setPreferredSize(new Dimension(100, 30));
			}
		jbt[0] = new JButton("Annuler");
		jbt[1] = new JButton("Valider");
		
		jbt[1].addActionListener(new ModifierUser());
		jbt[2] = new JButton("Retour");
		jbt[2].setVisible(false);
		jbt[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActionPerformed(evt);
            }
        });
		
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
	
        class selection implements ActionListener {

        public void actionPerformed(ActionEvent e){
            	try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            
            Connection c1 =DriverManager.getConnection(url, user, pass1);
            
            System.out.println("Connection bien etablie");
            
            String soc;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
           String requete ="SELECT * FROM utilisateur WHERE Id='"+Box.getSelectedItem() +"'";
            ResultSet c = a.executeQuery(requete);
            while(c.next()){
               
                for (int i = 0; i < jtf.length; i++) {
                    jtf[i].setText(c.getString(i+2));
                }
                
             
           }
            
            }catch(Exception ex){
            
            }
        
        }
        }
	
	class ModifierUser implements ActionListener {

        public void actionPerformed(ActionEvent e){
            
          
                     Entité_et_fonction.Admin Ad=new  Entité_et_fonction.Admin();
                     Ad.modifierUser((String) Box.getSelectedItem(),jtf[0].getText() ,jtf[1].getText() );
          
                    for (int i = 0; i < jtf.length; i++) {
                         jtf[i].setText("");
                     }
   
            }
        }
	
	 private void jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		 Interface.Admin A = new Interface.Admin();
         this.setVisible(false);
         A.setVisible(true);
	    }//GEN-LAST:event_jButton6ActionPerformed


}
