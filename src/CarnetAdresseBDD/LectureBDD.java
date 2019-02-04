package CarnetAdresseBDD;

import java.security.Key;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LectureBDD {

	
/********************* Variables *********************/
	private String url;
	
	// information de cryptage
	private int pswdIterations = 65536  ;
	private int keySize = 256;
	private byte[] ivBytes;
	private byte[] saltBytes = {0,1,2,3,4,5,6};
	private static byte[] keyValue=new byte[] {'0','2','3','4','5','6','7','8','9','1','2','3','4','5','6','7'};// your key


/********************* Constructeur *********************/

	public LectureBDD(String url) {
		super();
		this.url = url;
		                
	}

	
/********************* Getter / Setter *********************/
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
/********************* Fonctions *********************/

	
	public void ajouter(Echantillon echantillon) {
		
		try {
			String prenom = encrypt(echantillon.getPrenom());
			String titre = encrypt(echantillon.getTitre());
			String nom = encrypt(echantillon.getNom());
			String adresse = encrypt(echantillon.getAdresse());

			// créer un echantillon crypté (id  = 0 car il n'est pas util pour l'ajout)
			Echantillon echant_crypt = new Echantillon(0, titre, nom, prenom, adresse);
			
			echant_crypt.afficher();
			
			Principale.conn.ajouter(echant_crypt);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void remplirTab(ArrayList<Echantillon> tab) {
				
		tab.clear();
		
		
		
		try {
			for(Echantillon echantillon: Principale.conn.remplirTab()) {
			
				String prenom = decrypt(echantillon.getPrenom());
				String titre = decrypt(echantillon.getTitre());
				String nom = decrypt(echantillon.getNom());
				String adresse = decrypt(echantillon.getAdresse());
	
				// créer un echantillon crypté (id  = 0 car il n'est pas util pour l'ajout)
				Echantillon echant_decrypt = new Echantillon(echantillon.getId(), titre, nom, prenom, adresse);
				
				tab.add(echant_decrypt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// encrypte unecaine de caract�re
    public static String encrypt(String plainText) throws Exception 
    {
    	// cr�ation d'une cl� de cryptage
    	Key key = generateKey();
    	
    	// pr�paration du chiffreur avec l'algorithme AES
        Cipher chiper = Cipher.getInstance("AES");
        
        // initialisation avec la cl� en mode encrypteur
        chiper.init(Cipher.ENCRYPT_MODE, key);
        
        // encryptage
        byte[] encVal = chiper.doFinal(plainText.getBytes());
        
        // transformation du cryptage en chaine de caract�res
        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        
        // retourne la chaine encrypt�e
        return encryptedValue;
    }

    public static String decrypt(String encryptedText) throws Exception 
    {
    	// cr�ation d'une cl� de cryptage
        Key key = generateKey();
        
    	// pr�paration du chiffreur avec l'algorithme AES
        Cipher chiper = Cipher.getInstance("AES");
        
        // initialisation avec la cl� en mode d�crypteur
        chiper.init(Cipher.DECRYPT_MODE, key);
        
        //d�cryptage de la chiane de caract�res
        byte[] decordedValue = Base64.getDecoder().decode(encryptedText);
        byte[] decValue = chiper.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        
        // retourne la chaine d�crypt�e
        return decryptedValue;
    }

    
    // g�n�rateur de cl� de cryptage
    private static Key generateKey() throws Exception 
    {
            Key key = new SecretKeySpec(keyValue, "AES");
            return key;
    }
	
	
	
}
