
package Entité_et_fonction;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Interface.Authentification;
public class Personne {
    
	private static String STATUT = "Admin";
    private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
     
     private  static String user="root"; 
 
     private static String pass1="";
     private static String IdP;
      private static String NomP;
     private static String PrenomP;
      private String PwdP;
      //qui va servir à créer un utilisateur simple
    public Personne(String IdP, String NomP, String PrenomP ,String PwdP) {
        this.IdP = IdP;
        this.NomP = NomP;
        this.PrenomP = PrenomP;
        this.PwdP = PwdP;
    }
    public Personne(){
        
    }

  
    
    //pour l'uthentification
    public Personne(String IdP ,String PwdP) {
        this.IdP = IdP;
        this.PwdP = PwdP;
    }
    
   
      public String getIdP() {
        return IdP;
    }

    public void setIdP(String IdP) {
        this.IdP = IdP;
    }

    public String getNomP() {
        return NomP;
    }

    public void setNomP(String NomP) {
        this.NomP = NomP;
    }

    public String getPrenomP() {
        return PrenomP;
    }

    public void setPrenomP(String PrenomP) {
        this.PrenomP = PrenomP;
    }
    
      public String getPwdP() {
        return PwdP;
    }

    public void setPwdP(String PwdP) {
        this.PwdP = PwdP;
    }


    
  
   public  void  authentification(){
       Utilisateur usr = new Utilisateur();
        try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection c1=DriverManager.getConnection(url, user, pass1);
             Statement a = c1.createStatement();
             String sql ="SELECT * FROM utilisateur WHERE Id='"+getIdP()+"'";
                 ResultSet b = a.executeQuery(sql);
               if (b.next()) {
                String Mot_de_passe = b.getString("Pass_word");
                String status = b.getString("Statut");
                if(Mot_de_passe.equals(getPwdP())){
                	if(status.equals(STATUT)) {
                		Interface.Admin f = new Interface.Admin();
                        f.setVisible(true);
                       usr.setStatus("Admin");
                	}else {
					
                		Interface.Utilsateurs User = new Interface.Utilsateurs();
                		User.setVisible(true);
                                usr.setStatus("USER");
					}
                    
                    JOptionPane.showMessageDialog(null, "Connexion réusie !!!", "RSA", JOptionPane.INFORMATION_MESSAGE);
                    
                
                    BigInteger n = new BigInteger(b.getString("n"));
                    usr.setN(n);
                    
                    BigInteger e = new BigInteger(b.getString("e"));
                    usr.setE(e);
                    
                    BigInteger d = new BigInteger(b.getString("d"));
                    usr.setD(d);
                    
                    usr.setPrenomP(b.getString("Prenom"));
                    usr.setNomP(b.getString("Nom"));
                    usr.setIdP(b.getString("Id"));
                    
                    System.out.println(usr.getN());
                    System.out.println(usr.getE());
                    System.out.println(usr.getD());
                    
                    System.out.println(usr.getIdP());
                    System.out.println(usr.getPrenomP());
                    System.out.println(usr.getNomP());
                    
                }else{
                    Authentification A =new Authentification();
                    A.setVisible(true);
                   JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "RSA", JOptionPane.ERROR_MESSAGE);
                 
                }
                
            } else {
                   
                    Authentification A =new Authentification();
                    A.setVisible(true);
                   JOptionPane.showMessageDialog(null, "Lgin incorect", "RSA", JOptionPane.ERROR_MESSAGE);
                
            }
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
        
    }
    
       
    public void monProfil(String IdRe){
                try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection c1=DriverManager.getConnection(url, user, pass1);
             Statement a = c1.createStatement();

                 int b = a.executeUpdate("UPDATE  utilisateur SET Id='"+getIdP()+"'" + ",Nom='"+getNomP()+"' " + ",Prenom='"+getPrenomP()+"' " + ",Pass_word='"+getPwdP()+"'WHERE Id="+IdRe);
                   
           JOptionPane.showMessageDialog(null,"Modification bien effectuée", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
        
    }
    
}
