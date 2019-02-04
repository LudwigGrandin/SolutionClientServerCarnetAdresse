package CarnetAdresseBDD;


public class Echantillon {

	private String titre;
	private String nom;
	private String prenom;
	private String adresse;
	private int id;
	
	
	public Echantillon(int id, String titre, String nom, String prenom, String adresse) {
		super();
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
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


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return id+";"+titre + ";" + nom + ";" + prenom + ";" + adresse;
	}
	
	
	public void afficher() {
		System.out.println(toString());
	}
	
	
	
	
}
