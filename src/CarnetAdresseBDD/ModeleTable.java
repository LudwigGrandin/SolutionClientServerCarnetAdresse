package CarnetAdresseBDD;


import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel {
	
	/**
	 * 
	 */
	
/******************** Variables ************************/

	
	private static final long serialVersionUID = 1L;

	private ArrayList<Echantillon> data = new ArrayList<>();
	
	private String[] entete = {"Titre", "Nom", "Prenom", "adresse"};
	
	private String title;
	
	
/******************** Constructeur ************************/
	
	
	public ModeleTable() {
		LectureBDD.remplirTab(data);
	}


/******************** Getter / Setter ************************/

	public ArrayList<Echantillon> getData() {
		return data;
	}
	
	
	public void setData(ArrayList<Echantillon> data) {
		this.data = data;
	}
	
	
	public String[] getEntete() {
		return entete;
	}
	
	
	public void setEntete(String[] entete) {
		this.entete = entete;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
/******************** Fonctions ************************/

	// ceci n'est pas un getter, recup�re juste la taille du tableau ( nombre de ligne )
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	// idem , mais r�cup�re le nombre de colonnes
	@Override
	public int getColumnCount() {
		return entete.length;
	}
	
	// idem, mais r�cup�re le nom des colonnes
	@Override
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}
	
	// enfin une vraie fonction, elle permet d'ajouter un �l�ment au tableau
	public void addData (Echantillon echantillon) {
		data.add(echantillon);
		
		// met � jour le tableau 
		this.fireTableRowsInserted(this.data.size()-1, this.data.size()-1);
	}
	
	// supprime un �l�ment du tabeau
	public void removeData(int index) {
		try {
			// retire un �l�ment de l'arrayList data
			data.remove(index);
			
			// le retire du tableau , mise � jour comme pour l'ajout
			this.fireTableRowsInserted(index, index);
		} catch(ArrayIndexOutOfBoundsException e) {
			
			// si erreur il y a, affiche un pop up d'erreur
			JOptionPane.showMessageDialog(null, "Aucune ligne s�lectionn�e", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}


	// r�cup�re la valeur d'un case en fonction de la ligne
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Titre
			return data.get(rowIndex).getTitre();

		case 1:
			// Nom
			return data.get(rowIndex).getNom();

		case 2:
			// Prenom
			return data.get(rowIndex).getPrenom();

		case 3:
			// Adresse
			return data.get(rowIndex).getAdresse();
		default:
			throw new IllegalArgumentException();
		}
	}

	
}
