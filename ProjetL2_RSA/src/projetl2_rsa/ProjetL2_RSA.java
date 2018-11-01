/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetl2_rsa;

import Entité_et_fonction.Admin;
import Entité_et_fonction.Algorithme;
import Entité_et_fonction.Personne;
import Entité_et_fonction.Utillisateur_avec_AES;
import Interface.Cle_pub;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import Interface.Authentification;
/**
 *
 * @author Soda Ndiaye
 */

public class ProjetL2_RSA {

    public static void main(String[] args) {
   
    	/*
    Utillisateur_avec_AES Aes =new Utillisateur_avec_AES();
     Scanner Sc =new Scanner(System.in);
        System.out.println("Entrez votre message");
        String message =Sc.nextLine();
        Aes.GenKeyAES();
        System.out.println("La clé AES est :"+Aes.getCleAES());
        Aes.ChiffrementAES(message);
        System.out.println("Le chiffré est :"+ Aes.ChiffrementAES(message));
        Aes.DechiffrementAES(Aes.ChiffrementAES(message));
        System.out.println("Le clair est :"+ Aes.DechiffrementAES(Aes.ChiffrementAES(message)));
     // Authentification A= new Authentification();
      //A.setVisible(true);
                */
    	Authentification name = new Authentification();
    	name.setVisible(true);
    }
    
}
