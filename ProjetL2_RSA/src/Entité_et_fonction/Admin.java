
package Entité_et_fonction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Admin extends Utilisateur{
    private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
     
     private static String user="root"; 
 
     private static String pass1="";

    public Admin(String IdP, String NomP, String PrenomP, String PwdP) {
        super(IdP, NomP, PrenomP, PwdP);
    }

   public Admin(){
       
   }
   

  
         public void ajouterUser(String Id ,String Prenom,String Nom ,String Pwd ,String statut){
       	
             Utilisateur usr = new Utilisateur();
        try {
            usr.genKey();
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
		try {
		Connection c=DriverManager.getConnection(url, user, pass1);
                System.out.println("Connection etablie");
                PreparedStatement a = c.prepareStatement("INSERT INTO utilisateur VALUES(?, ?, ?, ?, ?, ?, ?,? )");
         	a.setString(1, Id);
	
		a.setString(2, Nom);
	            
	        a.setString(3, Prenom);
	            
	        a.setString(4, Pwd);
                
                a.setString(5, usr.getStrN());
                
                a.setString(6, usr.getStrE());
                
                a.setString(7, usr.getStrD());
                
                 a.setString(8, usr.getStatus());
	  
                a.executeUpdate();                   
                
           JOptionPane.showMessageDialog(null,"Ajout bien effectué", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
            
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
	}
         
         public void affiche_av_modUser(String IdRe){
                    try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection c1=DriverManager.getConnection(url, user, pass1);
             Statement a = c1.createStatement();
             String sql="SELECT * FROM  utilisateur WHERE Id='"+IdRe;
                 ResultSet b = a.executeQuery(sql);
                   
           
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
         }
         
         
         public void modifierUser(String IdU ,String PrenomU,String NomU ){
                try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection c1=DriverManager.getConnection(url, user, pass1);
             Statement a = c1.createStatement();

             a.executeUpdate("UPDATE  utilisateur SET Nom='"+NomU+"' " + ",Prenom='"+PrenomU+"'WHERE Id='"+IdU+"'");
                   
           JOptionPane.showMessageDialog(null,"Modification bien effectuée", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
         }
         
         
         public void supprimerUser(String  IdU){
              try {
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
               // String Ver ="SELECT * FROM utilisateur WHERE Id"+IdU;
                String requete= "DELETE FROM utilisateur WHERE Id='"+IdU+"'";
                Connection Con = DriverManager.getConnection(url,user,pass1);
                System.out.println("Connection etablie");
                 Statement a = Con.createStatement();
	         a.executeUpdate(requete);
	          /*if(!b.next()){
                  JOptionPane.showMessageDialog(null,"Cet utilisateur n' existe pas", "RSA", JOptionPane.INFORMATION_MESSAGE);
                }
                  else{
                Statement st =  Con.createStatement();
                st.execute(requete);
                JOptionPane.showMessageDialog(null,"Suppression bien effectuee", "RSA", JOptionPane.INFORMATION_MESSAGE);
                  }*/
                
            }catch(Exception e1){
                e1.printStackTrace();
            }
         }

   

     }
    

