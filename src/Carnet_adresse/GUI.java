package Carnet_adresse;

/**
 * @author Ludwig
 * @Version 1.0
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class GUI extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	
	/*********************** ATTRIBUTS *************************/
	
	private JMenuBar menuBar;
	private JMenu menuFichier;
	private JMenuItem itemAjouter, itemSupprimer, itemQuitter;
	private JTable tableau;
	Panneau pannel;
	ModeleTable table = new ModeleTable();
	//Partie Gestion fichier
	String key = "rt2018*";
	String cheminFichier = "";
	String algo="AES";
	GestionFichier gFichier = new GestionFichier(cheminFichier, key, algo);
	
	/********************** CONSTRUCTEUR **************************/
	
	public GUI(int pLarg, int pHaut, boolean pResize, String pTitre)
	{
		//On d�fini les caract�ristiques de notre fenetre
		this.setSize(pLarg,  pHaut);
		this.setResizable(pResize);
		
		//On cr�e la structure pour placer nos boutons
		this.setLayout(new BorderLayout());
		
		this.setTitle("JTable avec mod�le statique");
		
		//On ne fait rien si l'utilisateur clique sur la croix
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//On d�finit les sous ensembles
        this.menuBar = new JMenuBar();
		this.menuFichier= new JMenu("Fichier");
							
		this.itemAjouter = new JMenuItem();
		this.itemAjouter.setText("Ajouter");
		
		this.itemSupprimer = new JMenuItem();
		this.itemSupprimer.setText("Supprimer");
		
		this.itemQuitter = new JMenuItem();
		this.itemQuitter.setText("Quitter");
		
		//On ajoute les sous ensembles � l'ensemble MenuFichier
		this.menuFichier.add(itemAjouter);
		this.menuFichier.add(itemSupprimer);
		this.menuFichier.add(itemQuitter);
		
		//On Ajoute MenuFichier � la barre menu barre
		this.menuBar.add(menuFichier);
		
				
		//On place la bare MenuBar en haut de la fentre
		this.add(menuBar, BorderLayout.NORTH);
		
		this.tableau = new JTable(table);
		//Permet d'afficher un tableau dans une fenetre avec une barre lat�ral et de la centrer
		this.add(new JScrollPane(tableau),BorderLayout.CENTER);
		
		//Permet d'afficher l'ensemble correctement
		//pack();
		
		
		
		
		
		
		
		// ActionListener : Ecoute la fenetre
		this.itemAjouter.addActionListener(this);
		this.itemSupprimer.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		
	}
	
	
	
	/***************************** METHODES ***********************/
	
	//M�thodes action Performed respondant au Action Listener
	public void actionPerformed(ActionEvent actBtn) 
	{
		if(actBtn.getSource() == itemAjouter)
		{
			this.pannel = new Panneau();
			
			if(pannel.choixNUser == 0)
			{
				//Lorsque j'appuie sur le bouton OK de mon panneau, tous les �l�ments entr�es sont envoy�s � la m�thode addData du model
				//Cel� permet d'actionner le processus pour entrer les information dans l'array list et afficher les informations dans le tableau.
				this.table.addData(pannel.getTitre(), pannel.getNom().getText(), pannel.getPrenom().getText(), pannel.getAdresse().getText());
			}
		}
		if(actBtn.getSource() == itemSupprimer)
		{
			//Si une ligne est selectionn� alors on ex�cute la m�thode pour supprimer une ligne dans la classe ModelTable
			if(tableau.getSelectedRow() == 0)
			{
				this.table.removeData(tableau.getSelectedRow());
			}
			else
			{}
		}
		if(actBtn.getSource() == itemQuitter)
		{
			//Si l'on clique sur le bouton "quitter", une fenetre s'affiche avec un choix � faire. Si l'utilisateur confirme 
			//on r�cup�re la valeur dans une variable puis on ferme propremen l'application.
			int quitter = JOptionPane.showConfirmDialog(itemQuitter, "Voulez vous quitter l'application");
			
			if(quitter == 0)
			{
				System.exit(0);
			}
			else if (quitter == 1)
			{}
			
			
			
		}
		
	}
	
	
	
}
