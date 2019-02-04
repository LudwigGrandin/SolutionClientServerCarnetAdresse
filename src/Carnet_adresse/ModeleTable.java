package Carnet_adresse;

/**
 * @author Ludwig
 * @Version 1.0
 * 
 */

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



	public class ModeleTable extends AbstractTableModel{
		
		//Notre ArrayList va contenir les valeurs de chaque ligne de notre tableau
		private ArrayList<Echantillon> data = new ArrayList<Echantillon>();
		
		//Une tableau entete est créer pour définir l'entete du tableau avec les valeurs pour chaque colonne
		private String[] title = {"Titre", "Prénom", "Nom", "Adresse"};
		
		private Echantillon echantillon;
		
		
	
		private static final long serialVersionUID = 1L;
	/************************* ATTRIBUTS  *******************************/
	
	
	
	
	/************************** CONSTRUCTEUR *******************/
	
		//Le constructeur de la class ModelTable est vide mais on pourrait y ajouter une ligne appellant la méthode data.add si l'on souhaitais remplir une ligne à l'initialisation
	public ModeleTable()
	{}
	
	/*************************** GETTERS/SETTERS ******************/
	
	//Les getters de la class ModelTable sont utilisés par la class mère AbstractTableModel
	public int getRowCount() {
		
		//Retourne le nombre de ligne du tableau
		return this.data.size();
	}


	public int getColumnCount() {
		//retourne le nombre d'éléments dans l'entete permettant de définir le nombre de colonne
		//du tableau
		return this.title.length;
	}
	
	public String getColumnName(int columnIndex)
	{
		return this.title[columnIndex];
		
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		//retourne la valeur de la case demandé par la classe mère
		switch(columnIndex){
        case 0:
            return this.data.get(rowIndex).getTitre();
        case 1:
            return this.data.get(rowIndex).getPrenom();
        case 2:
            return this.data.get(rowIndex).getNom();
        case 3:
            return this.data.get(rowIndex).getAdresse();
        default:
            return null; //Ne devrait jamais arriver*/
		}
	}
	
	/*************************** METHODES ***********************/

	
	public void addData(String pTitre, String pNom, String pPrenom, String pAdresse)
	{
		//A chaque appel de lavfonction add data, on recréer un nouvel échantillon afin que
		//le précédent échantillon ne soit pas écraser par le nouvel échantillon
		this.echantillon = new Echantillon(pTitre, pNom, pPrenom, pAdresse);
		
		//On ajoute les différentes valeurs de notre tableau à notre ArrayList
		this.data.add(this.echantillon);
		
		//On Actualise l'affichage du tableau
		this.fireTableRowsInserted(this.data.size()-1, this.data.size()-1);
		
	}
	
	public void removeData (int rowIndex)
	{
		//On supprime une ligne de notre tableau
		this.data.remove(rowIndex);
		
		//On actualise l'affichage du tableau
		this.fireTableDataChanged();
	}




	

	
}
