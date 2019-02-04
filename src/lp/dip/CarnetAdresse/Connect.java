package lp.dip.CarnetAdresse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connect {
	
/****************** Variable ******************/
	
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	private Statement state;
	private PreparedStatement preparedState;
	private ResultSet result;
	
	private Connection connexion;
	
/**************** Constructeur ****************/
	
	public Connect(String driver, String url, String user, String pass) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		connectBDD();
	}
	
/**************** Getter / Setter ****************/
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public Connection getConnexion() {
		return connexion;
	}
	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	

/**************** Méthodes ****************/
	
	// connect à la BDD
	public void connectBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnexion(DriverManager.getConnection( url, user, pass));
			
			try {
			String sql = "SELECT * FROM contacts";
			Statement state = connexion.createStatement();
			state.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				
//				String sql = "CREATE TABLE data( id SERIAL NOT NULL, nom VARCHAR(10) NOT NULL, tatoo INTEGER NOT NULL, naiss DATE NOT NULL, taill DOUBLE NOT NULL, PRIMARY KEY(id));";
//				Statement state = connexion.createStatement();
//				state.executeQuery(sql);
			}
			
			/*try {
				String sql = "SELECT * FROM Distance";
				Statement state = connexion.createStatement();
				state.executeQuery(sql);
				} catch (SQLException e) {
//					String sql = "CREATE TABLE data( id SERIAL NOT NULL, nom VARCHAR(10) NOT NULL, tatoo INTEGER NOT NULL, naiss DATE NOT NULL, taill DOUBLE NOT NULL, PRIMARY KEY(id));";
//					Statement state = connexion.createStatement();
//					state.executeQuery(sql);
				}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Y a un p'tit problème dans ta connection\nTa base n'existe pas");
		}
		
	}
	
	
	
	public void ajouter(Echantillon echantillon) {
		
		try {
			
			String sql = "INSERT INTO contacts(titre, nom, prenom, adresse) VALUES (?, ?, ?, ?)";
			 
			preparedState = connexion.prepareStatement(sql);
			
			preparedState.setString(1, echantillon.getTitre());
			preparedState.setString(2, echantillon.getNom());
			preparedState.setString(3, echantillon.getPrenom());
			preparedState.setString(4, echantillon.getAdresse());
			
			System.out.println(preparedState);
			
			preparedState.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Echantillon> remplirTab() {
		
		ArrayList<Echantillon> tab = new ArrayList<>();
		
		// vide le tableau pour pouvoir le remplir correctement;
		
		try {
			
			String sql = "SELECT * FROM contacts";
			 
			state = connexion.createStatement();

			result = state.executeQuery(sql);
			
			while(result.next()) {
				tab.add(new Echantillon(result.getString("titre"), result.getString("nom"), result.getString("prenom"), result.getString("adresse")));
			}
			
		}catch(SQLException e) {
			
		}
		
		return tab;
	}
	
	public void selectData() {
				
		// vide le tableau pour pouvoir le remplir correctement;
		
		try {
			
			String sql = "SELECT * FROM contacts";
			 
			state = connexion.createStatement();

			result = state.executeQuery(sql);
			
			while(result.next()) {
				System.out.println(result.getInt("id")+" "+ result.getString("titre")+" "+result.getString("nom")+" "+
						result.getString("prenom")+" "+result.getString("adresse"));
			}
			
		}catch(SQLException e) {
			
		}
		
	}
	
	public void supprimer(Echantillon echantillon) {
		
		try {
			
			String sql = "DELETE FROM contacts WHERE id = ?";
			 
			preparedState = connexion.prepareStatement(sql);
			
			//preparedState.setInt(1, echantillon.getId());

			
			preparedState.executeUpdate();
			
		}catch(SQLException e) {
			
		}
	}
	
}
