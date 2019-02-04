package Carnet_adresse;

/**
 * @author Ludwig
 * @Version 1.0
 * 
 */

public class Echantillon {
	
	/************************* ATTRIBUTS  *******************************/

	private String titre, nom, prenom, adresse;
	
	/************************** CONSTRUCTEUR *******************/
	
	public Echantillon(String pTitre, String pNom, String pPrenom,String pAdresse)
	{
		//On récupère les différentes variables de notre tableau dans un objet Echantillon
		this.titre = pTitre;
		this.nom = pNom;
		this.prenom = pPrenom;
		this.adresse = pAdresse;
		
	}
	
	/*************************** GETTERS/SETTERS ******************/
//Nos getters vont nous permettres de récupérer la valeur de nos variable hors de la class Echantillon
	public String getTitre() {
		return this.titre;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}
	
	/*************************** METHODES ***********************/

}
