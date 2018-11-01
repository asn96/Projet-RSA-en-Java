/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import Entité_et_fonction.InfoCli;
import Entité_et_fonction.Utilisateur;

/**
 *
 * @author Soda Ndiaye
 */
public class TableauClePriv extends javax.swing.JFrame {

	/**
	 * Creates new form TableauClePriv
	 */
	public TableauClePriv() {
		initComponents();
	}
	

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		CreateColonne();

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clé publique", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18), new java.awt.Color(0, 51, 204))); // NOI18N

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
		jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), new java.awt.Color(0, 51, 255)));

		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url= "jdbc:mysql://localhost:3306/projet_rsa";

			String user="root"; 

			String pass="";

			Connection c1 =DriverManager.getConnection(url, user, pass);

			System.out.println("Connection bien etablie");

			Statement a = c1.createStatement();

			ResultSet b = a.executeQuery("SELECT * FROM utilisateur ORDER BY Id DESC");



			String nom;

			String prenom;

			String id;


			while(b.next()){
				id = b.getString("Id");

				prenom = b.getString("Prenom");

				nom = b.getString("Nom");


				ligne(id, prenom, nom);

			}

		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		jScrollPane1.setViewportView(jTable1);

		jButton1.setBackground(new java.awt.Color(0, 102, 255));
		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("Valider");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
		

		jButton2.setBackground(new java.awt.Color(204, 0, 0));
		jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("Annuler");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(53, 53, 53)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(129, 129, 129)
						.addComponent(jButton2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
						.addGap(28, 28, 28))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

public void CreateColonne(){
        
        d=(DefaultTableModel) jTable1.getModel();
        d.addColumn("Identifiant");
        d.addColumn("Prenom");
        d.addColumn("Nom");
       
   

    }
	

	private void ligne(String id, String prenom, String nom) {
		// TODO Auto-generated method stub
		 Object[] line ={id, prenom, nom};
         
         d.addRow(line);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TableauClePriv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TableauClePriv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TableauClePriv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TableauClePriv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TableauClePriv().setVisible(true);
			}
		});
	}
	
	 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	     
		 int numline = jTable1.getSelectedRow();
	      Object idcli = d.getValueAt(numline, 0);
	      InfoCli UserInfo = new InfoCli(idcli);
	      UserInfo.InfoUserCli();
	     
		 if(STRING_VALUES.compareTo("CHIFFRER") == 0) {
			 System.out.println("validation reussie :" +UserInfo.getDcli());
		      Mes_cour_Chiffrer msg = new Mes_cour_Chiffrer();
		        this.setVisible(false);
		        msg.setVisible(true); 
	     }
		 if(STRING_VALUES.compareTo("COURT_CHIFFREMENT") == 0) {
	    	 
		     	Mes_cour_verifier_signature Verification = new Mes_cour_verifier_signature();
		     	Verification.setSTRING_VALUES(STRING_VALUES);
		         this.setVisible(false);
		         Verification.setVisible(true);
		     }
			
		  if(STRING_VALUES.compareTo("LONG_CHIFFREMENT") == 0) {
		    	 
			     	Mes_cour_verifier_signature Verification = new Mes_cour_verifier_signature();
			     	Verification.setSTRING_VALUES(STRING_VALUES);
			         this.setVisible(false);
			         Verification.setVisible(true);
		  }
		  
		  
	    }//GEN-LAST:event_jButton1ActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	DefaultTableModel d;
	private static String STRING_VALUES;
	// End of variables declaration//GEN-END:variables
	public static String getSTRING_VALUES() {
		return STRING_VALUES;
	}

	public static void setSTRING_VALUES(String sTRING_VALUES) {
		STRING_VALUES = sTRING_VALUES;
	}
}