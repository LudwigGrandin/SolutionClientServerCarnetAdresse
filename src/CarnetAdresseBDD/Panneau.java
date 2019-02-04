package CarnetAdresseBDD;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panneau extends JPanel{	
	
/******************** Variables ***********************/	
	
	private final static int LARGEUR = 120;
	private final static int HAUTEUR = 20;

	private static final long serialVersionUID = 1L;

	private JComboBox<String> titre = new JComboBox<>();
	
	private JTextField nom = new JTextField();
	private JTextField prenom = new JTextField();
	
	private JTextArea adresse = new JTextArea();
	
	private JPanel panLabel, panSaisie;
	
	private JLabel labTitre, labNom, labPrenom, labAdresse;
	
	
/******************** Constructeur ***********************/	
	
	public Panneau() {
		
			labTitre = new JLabel("Titre : ");
			labNom = new JLabel("Nom : ");
			labPrenom = new JLabel("Prenom : ");
			labAdresse = new JLabel("Adresse : ");
			
			labTitre.setSize(LARGEUR, HAUTEUR);
			labNom.setSize(LARGEUR, HAUTEUR);
			labPrenom.setSize(LARGEUR, HAUTEUR);
			labAdresse.setSize(LARGEUR, HAUTEUR);

			
			titre.setSize(LARGEUR, HAUTEUR);
			nom.setSize(LARGEUR, HAUTEUR);
			prenom.setSize(LARGEUR, HAUTEUR);
			
			titre.addItem("Homme");
			titre.addItem("Femme");
			titre.addItem("Hélicoptère Apache");

			
//			panLabel = new JPanel();
			panSaisie = new JPanel();
			

			this.setLayout(new BorderLayout());
//			this.add(panLabel, BorderLayout.WEST);
			this.add(panSaisie, BorderLayout.NORTH);
			this.add(labAdresse, BorderLayout.SOUTH);
			this.add(adresse, BorderLayout.SOUTH);
			
			GridLayout grid = new GridLayout(4, 2);
//			GridLayout g2 = new GridLayout(3, 0);
			
//			g1.setVgap(10);			
			
//			panLabel.setLayout(g1);
			panSaisie.setLayout(grid);

			panSaisie.add(labTitre);
			panSaisie.add(titre);
			panSaisie.add(labNom);
			panSaisie.add(nom);
			panSaisie.add(labPrenom);
			panSaisie.add(prenom);
			panSaisie.add(labAdresse);
			
	}
	
	
/*********************** Getter / Setter ********************/

	public JComboBox<String> getTitre() {
		return titre;
	}

	public void setTitre(JComboBox<String> titre) {
		this.titre = titre;
	}

	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}

	public JTextArea getAdresse() {
		return adresse;
	}

	public void setAdresse(JTextArea adresse) {
		this.adresse = adresse;
	}


	public JPanel getPanLabel() {
		return panLabel;
	}

	public void setPanLabel(JPanel panLabel) {
		this.panLabel = panLabel;
	}

	public JPanel getPanSaisie() {
		return panSaisie;
	}

	public void setPanSaisie(JPanel panSaisie) {
		this.panSaisie = panSaisie;
	}

	public JLabel getLabTitre() {
		return labTitre;
	}

	public void setLabTitre(JLabel labTitre) {
		this.labTitre = labTitre;
	}

	public JLabel getLabNom() {
		return labNom;
	}

	public void setLabNom(JLabel labNom) {
		this.labNom = labNom;
	}

	public JLabel getLabAdresse() {
		return labAdresse;
	}

	public void setLabAdresse(JLabel labAdresse) {
		this.labAdresse = labAdresse;
	}
	
	/******************** Fonctions ************************/


}
