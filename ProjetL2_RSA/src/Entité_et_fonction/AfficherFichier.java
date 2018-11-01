package Entité_et_fonction;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AfficherFichier {

	private String nomFichier;
	private String fichierContenu="";
	private String NormalContain;
	public AfficherFichier(String nomFichier) {
		super();
		this.nomFichier = nomFichier;
	}
	
	public void LireFichier()
    {
    try 
      {
      RandomAccessFile raf = new RandomAccessFile(nomFichier, "r");
      String ligne=null;
      while ( (ligne = raf.readLine()) != null )
        {
        this.fichierContenu += ligne;
        }
      }
   catch (IOException e) 
     {
     System.out.println("erreur dans: " + e);
     }
    }

	public String getFichierContenu() {
		this.NormalContain = fichierContenu.substring(7, fichierContenu.length());
		return NormalContain;
	}

	public void setFichierContenu(String fichierContenu) {
		this.fichierContenu = fichierContenu;
	}
   


}
