/**
/**
 * @author Ludwig
 */
package Carnet_adresse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.crypto.spec.SecretKeySpec;

public class GestionFichier {
	
	private String key, algo;
	private String file;
	private BufferedReader br;
	private PrintWriter pw;
	private SecretKeySpec AES;
	

	public GestionFichier(String cheminFichier, String pKey, String pAlgo)
	{
		this.key = pKey;
		this.algo = pAlgo;
		this.file = cheminFichier;
	
	}
	
	public void lireFichierChiffre(ModeleTable pDonnees)
	{
		try {
			br = new BufferedReader(new FileReader(file));
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException IOex)
		{
			System.out.println("Impossible de lire le fichier");
		
		}
		
		
	}
	
	public void enregistrerFichierChiffre(ModeleTable pDonnees)
	{
		//AES = new SecretKeySpec();
		
		
		try {
			pw = new PrintWriter(new FileWriter(file));
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
