package Entité_et_fonction;
import java.io.Serializable;
import java.math.*;
import java.security.*;
import java.util.Scanner;

public class Algorithme  implements Serializable{

        //Pour avoir 1 avec BigInteger one = BigInteger.ONE;
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
    private BigInteger d = null;
    private BigInteger e = null;
    private BigInteger n = null;
    private BigInteger p = null;
    private BigInteger q = null;
    //private int N;
    private BigInteger phi0;


    public Algorithme() {
        this.phi0 = phi0;
        this.d=d;
        this.e= e;
        this.p=p;
        this.q=q;
        this.n = n;
    }
    
        // les getteurs et setteurs
            public BigInteger getD() {
                return d;
            }

            public void setD(BigInteger d) {
                this.d = d;
            }

            public BigInteger getE() {
                return e;
            }

            public void setE(BigInteger e) {
                this.e = e;
            }

            public BigInteger getN() {
                return n;
            }

            public void setN(BigInteger n) {
                this.n = n;
            }

            public BigInteger getP() {
                return p;
            }

            public void setP(BigInteger p) {
                this.p = p;
            }

            public BigInteger getQ() {
                return q;
            }

            public void setQ(BigInteger q) {
                this.q = q;
            }

            public BigInteger getPhi0() {
                return phi0;
            }

            public void setPhi0(BigInteger phi0) {
                this.phi0 = phi0;
            }
            
             // gération des clés
         public void genKey(){
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
        
            
           }
   
   
    // cette methode qui chiffre prend en argument le message et t retourne un chiffré
    public BigInteger chiffrement(String message,BigInteger e,BigInteger n)
    {
        BigInteger chiffre= null;
        //pour convertir le message
        byte []mesByte =message.getBytes();
        //byte mes =Byte.valueOf(message);
        BigInteger mesInt = new BigInteger(mesByte);
        //pour diviser le message en paquet de octet
       // if (mesInt.length() <= (1024 / 8))
       // {
          //  if (e != null && n != null && mesInt.length < Integer.MAX_VALUE)
           // {
                chiffre = mesInt.modPow(e, n);
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
    
    //la méthode qui vérifie la signature
    public boolean  verification(BigInteger signe ,String mesSig,BigInteger e,BigInteger n ){
        boolean resultat;
         byte []mesByte =mesSig.getBytes();
        BigInteger mesInt = new BigInteger(mesByte);
        if(mesInt.equals(signe.modPow(e, n))){
            resultat = true;
            System.out.println("La signature est valide");
        }
        else{
            resultat = false;
            System.out.println("La signature n'est pas valide");
        }
           return resultat;
    }
    
    //pour afficher les varibles de l'algorithme : gération des clés
    public void  affiche1 (Algorithme t){
         System.out.println("p : "+this.p);
             System.out.println("q : "+this.q);
             System.out.println("n = pxq : "+this.n);
             System.out.println("phi = (p-1)(q-1): "+this.phi0);
             System.out.println("e qui est premier:"+this.e);
             System.out.println("d :"+this.d);
    }
    
    //pour afficher le chiffré
    public void affiche (BigInteger mes){
        System.out.println("Le chiffré est "+mes);
    }
    
    //pour afficher le déchiffré
    public void affiche2 (String chif){
        System.out.println("Le message est "+chif);
    }
    
    //pour afficher la signature
    public  void affiche3(BigInteger signe){
        System.out.println("La signature est :"+signe);
    }

}
    

