package Entité_et_fonction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class EcrireFichier {
	
	FileOutputStream fichier;
	ObjectOutputStream objet=null;
	private String contenu = "";
	private String nomFichier = "";
	public EcrireFichier (String nomFichier, String contenu){
		this.nomFichier = nomFichier;
		this.contenu = contenu;
		
	 try {
		fichier = new FileOutputStream(this.nomFichier+".txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		objet = new ObjectOutputStream(fichier);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void ecrireFichierInter (){
	 try {
		 
		objet.writeObject(contenu);
		JOptionPane.showMessageDialog(null,"Le fichier est enrégistré avec succé", "RSA", JOptionPane.INFORMATION_MESSAGE);
	} catch (IOException e) {
		// TODO Auto-generated castch block
		e.printStackTrace();
	}
	}
	public void fermer() throws IOException{
	 objet.close();
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
