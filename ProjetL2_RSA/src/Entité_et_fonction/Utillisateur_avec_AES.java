package Entité_et_fonction;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class Utillisateur_avec_AES extends Utilisateur {

            private  Cipher instanseAES;
           private static SecretKey CleAES;
            File f =new File("cleAES"); 
            
            public Utillisateur_avec_AES(String IdP, String NomP, String PrenomP, String PwdP) {
                super(IdP, NomP, PrenomP, PwdP);

            }

            public Utillisateur_avec_AES(){

            }

    public static SecretKey getCleAES() {
        return CleAES;
    }

    public static void setCleAES(SecretKey CleAES) {
        Utillisateur_avec_AES.CleAES = CleAES;
    }
            
            

            public SecretKey GenKeyAES() throws NoSuchAlgorithmException{
                // génération d'une clé AES de 128bits
                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                        keyGenerator.init(128);
                      	this.CleAES = keyGenerator.generateKey();
                      return CleAES;
            }

            public byte[] ChiffrementAES(String message ) throws Exception{
                        instanseAES =Cipher.getInstance("AES");
                        instanseAES.init(Cipher.ENCRYPT_MODE, CleAES);
                        byte[] ChiffreByte = instanseAES.doFinal(message.getBytes(/*"ISO-8859-1"*/));
                         //String chiffre = (new String(ChiffreByte));
               // return chiffre;
               return ChiffreByte;
            }

            public String DechiffrementAES(byte[] chiffre)throws Exception{
                          instanseAES =Cipher.getInstance("AES");
                        instanseAES.init(Cipher.DECRYPT_MODE, CleAES);
                         byte[] MessageByte = instanseAES.doFinal(chiffre);
                         String MesClair = (new String(MessageByte));
                    return MesClair;
                }
    
}
