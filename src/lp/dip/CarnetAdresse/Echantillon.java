package lp.dip.CarnetAdresse;


public class Echantillon {

	String titre, nom,prenom,adresse;
	
	
	public Echantillon(String pTitre, String pNom, String pPrenom, String pAddress) {
		super();
		titre = pTitre;
		nom=pNom;
		prenom=pPrenom;
		adresse=pAddress;
		
		
	}


	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String pPrenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return this.adresse;
	}


	public void setAdresse(String pAdresse) {
		this.adresse = pAdresse;
	}
	


	@Override
	public String toString() {
		return titre + ";" + nom + ";" + prenom + ";" + adresse;
	}
	
	
	public void afficher() {
		System.out.println(toString());
	}
	
	
	
	
}
