/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité_et_fonction;
import Interface.Authentification;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.ModificationPassWord;
import Interface.Profil;
import javax.swing.JOptionPane;

public class Utilisateur extends Personne implements Serializable{
  private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
     private static String Status;
     private static String user="root"; 
 
     private static String pass1="";
   private BigInteger p = null;
        private BigInteger q = null;
       // private int N;
        private BigInteger phi0;
       private static BigInteger n;
       private static BigInteger e;
       private static BigInteger d;
       
       
    

	private String strN, strD, strE;
        private final static BigInteger one = new BigInteger("1");
        private final static SecureRandom random = new SecureRandom();

    public Utilisateur( String IdP, String NomP, String PrenomP, String PwdP) {
        super(IdP, NomP, PrenomP, PwdP);
       // this.N = N;
        this.phi0 = phi0;
        this.n = n;
        this.e = e;
        this.d = d;
    }

   public  Utilisateur(){
       
   }
   
    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
    
      public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
      
             // gération des clés
         public void genKey() throws Exception{
         //p
        p = BigInteger.probablePrime(1024, random);
        //q
        q= BigInteger.probablePrime(1024, random);
        //phi0=(p-1)(q-1)
        phi0 = (p.subtract(one)).multiply(q.subtract(one));
        //
        //n=pq
        n = p.multiply(q);
        //e
        do{
            e=new BigInteger(128, random);
        }while(e.gcd(phi0).intValue()!=1);
        //d
        d=e.modInverse(phi0);
        // pour inserer les clés dans la base
        /*
        String strN =new String(n.toByteArray());
        String strE =new String(e.toByteArray());
        String strD =new String(d.toByteArray());
        */
        
        this.strN =n.toString();
        this.strE =e.toString();
        this.strD =d.toString();
        System.out.println("/**************************************************");
        System.out.println(strN+"taille"+strN.length());
        System.out.println("/**************************************************");
        System.out.println(strE+"taille"+strE.length());
        System.out.println("/**************************************************");
        System.out.println(strD+"taille"+strD.length());
        
        /*try {
        	Class.forName("com.mysql.jdbc.Driver");
        		Connection c=DriverManager.getConnection(url, user, pass1);
                System.out.println("Connection etablie");
                Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet b = st.executeQuery("SELECT * FROM utilisateur WHERE Id = '"+IdP+"'");
                b.first();
                
         	b.updateString("n",strN);
	
         	b.updateString("e",strE);
	            
	        b.updateString("d",strD);
	            
	        b.updateRow();                   
                
           JOptionPane.showMessageDialog(null,"Ajout bien effectué", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
            
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
        */    
           }

    public String getStrN() {
        return strN;
    }

    public void setStrN(String strN) {
        this.strN = strN;
    }

    public String getStrD() {
        return strD;
    }

    public void setStrD(String strD) {
        this.strD = strD;
    }

    public String getStrE() {
        return strE;
    }

    public void setStrE(String strE) {
        this.strE = strE;
    }
   
    
    
     // cette methode qui chiffre prend en argument le message et t retourne un chiffré (eRe ,nRe) la clé publique du receveur
    public BigInteger chiffrement(String message,BigInteger eRe,BigInteger nRe)
    {
        BigInteger chiffre= null;
        //pour convertir le message
        byte []mesByte =message.getBytes();
        //byte mes =Byte.valueOf(message);
        BigInteger mesInt = new BigInteger(mesByte);
                chiffre = mesInt.modPow(eRe, nRe);
            //}
                return chiffre;
    }
    
    // cette methode qui dechiffre prend en argument le  chiffré et retourne un  message
    public String dechiffrement(BigInteger chiffre,BigInteger d,BigInteger n ) {
        BigInteger chInt = chiffre.modPow(d, n);
          String message = new String(chInt.toByteArray());
        return message;
    }
    
   // La méthode qui signe
    public  BigInteger  Signature(String mesSig,BigInteger d,BigInteger n ){
       BigInteger signe= null;
        byte []mesByte =mesSig.getBytes();
        BigInteger mesInt = new BigInteger(mesByte);
                signe = mesInt.modPow(d, n);

        return signe;
   
    }
    
    //la méthode qui vérifie la signature (eEm ,nEm) la clé publique de l'emetteur
    public boolean  verification(BigInteger signe ,String mesSig, BigInteger eEm, BigInteger nEm ){
        boolean resultat;
         byte []mesByte =mesSig.getBytes();
        BigInteger mesInt = new BigInteger(mesByte);
        if(mesInt.equals(signe.modPow(eEm, nEm))){
            resultat = true;
             JOptionPane.showMessageDialog(null,"La signature est valide", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
        }
        else{
            resultat = false;
               JOptionPane.showMessageDialog(null,"La signature non valide", "RSA", JOptionPane.ERROR_MESSAGE);
          }
           return resultat;
    }
    
     public  void  modifierPassWord(String IdM ,String PassWord ,String NvPassWord ,String confirmer){
        try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection c1=DriverManager.getConnection(url, user, pass1);
             Statement a = c1.createStatement();
             String sql ="SELECT * FROM utilisateur WHERE Id='"+IdM+"'";
                 ResultSet b = a.executeQuery(sql);
               if (b.next()) {
                String Mot_de_passe = b.getString("Pass_word");
                String status = b.getString("Statut");
                if(Mot_de_passe.equals(PassWord)){
                	if(NvPassWord.equals(confirmer)) {
                	       try {
        
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
           
            Connection con=DriverManager.getConnection(url, user, pass1);
             Statement c = con.createStatement();

             c.executeUpdate("UPDATE  utilisateur SET Pass_word='"+NvPassWord+"'WHERE Id='"+IdM+"'");
               Profil P =new Profil();
               P.setVisible(true);
           JOptionPane.showMessageDialog(null,"Mot de passe modifier", "RSA", JOptionPane.INFORMATION_MESSAGE);
          
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
           	}else {
		JOptionPane.showMessageDialog(null, "Les deux champss saisis sont différents !!!", "RSA", JOptionPane.INFORMATION_MESSAGE);	
            	}
              }else{
                   // ModificationPassWord A =new ModificationPassWord();
                    //A.setVisible(true);
                   JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "RSA", JOptionPane.ERROR_MESSAGE);
                 
                }
                
            } 
          }catch(Exception e1){
        	  e1.printStackTrace();
          }
        
    }
    
   
}
