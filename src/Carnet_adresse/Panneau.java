package Carnet_adresse;

/**
 * @author Ludwig
 * @Version 1.0
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class Panneau extends JPanel{
	
	

	private static final long serialVersionUID = 1L;
	/************************* ATTRIBUTS  *******************************/
	private JComboBox<String> titre;
	private JTextField nom,prenom;
	private JTextArea adresse;
	private JPanel panLabel, panSaisie, panTotal;
	private JLabel labTitre, labNom,labPrenom, labAdresse;
	//Permet de mémoriser le choix de l'utilisateur sur l'ouverture de l'envoie des données dans le tableau (bouton ok)
	protected int choixNUser;
	
	/************************** CONSTRUCTEUR *******************/
	public Panneau()
	{	
		//On défini tous les objets disponible dans le panneau
		this.panTotal = new JPanel();
		this.panTotal.setLayout(new GridLayout(1,2));
		
		this.labTitre = new JLabel();
		this.labTitre.setText("Titre : ");
		this.titre = new JComboBox<String>();
		this.titre.addItem("Mr");
		this.titre.addItem("Mme");
		this.labNom = new JLabel();
		this.labNom.setText("Nom :");
		this.nom = new JTextField();
		this.labPrenom = new JLabel();
		this.labPrenom.setText("Prenom : ");
		this.prenom = new JTextField();
		this.labAdresse = new JLabel();
		this.labAdresse.setText("Adresse : ");
		this.adresse = new JTextArea();
		
		//On place les objet dans mon panneau suivant un format Gridlayout
		this.panLabel = new JPanel();
		this.panLabel.setLayout(new GridLayout(4,1));
		this.panLabel.add(labTitre);
		this.panLabel.add(labNom);
		this.panLabel.add(labPrenom);
		this.panLabel.add(labAdresse);
		
		this.panSaisie = new JPanel();
		this.panSaisie.setLayout(new GridLayout(4,1));
		this.panSaisie.add(titre);
		this.panSaisie.add(nom);
		this.panSaisie.add(prenom);
		
		this.adresse = new JTextArea(5,1);
		
		this.panTotal.add(panLabel);
		this.panTotal.add(panSaisie);
		
		this.setLayout(new BorderLayout());
		this.add(panTotal,BorderLayout.NORTH);
		this.add(adresse, BorderLayout.CENTER);
		//J'envoie à l'utilisateur la fenetre dans laquelle se trouve le panneau et tous ses éléments
		choixNUser = JOptionPane.showConfirmDialog(this,this, "Nouveau Contact", JOptionPane.OK_CANCEL_OPTION);
		
		
	}
	
	/*************************** GETTERS/SETTERS ******************/
	//Mes getters permettent de récupérer à partir de la class ModeleTbale les informations saisies par l'utilisateur
	public String getTitre()
	{
		return this.titre.getSelectedItem().toString();		
	}
	
	public JTextField getNom()
	{
		return this.nom;}
	
	public JTextField getPrenom()
	{
		return this.prenom;}
	
	public JTextArea getAdresse()
	{
		return this.adresse;}
	
	/*************************** METHODES ***********************/
	
	
	
	
}
