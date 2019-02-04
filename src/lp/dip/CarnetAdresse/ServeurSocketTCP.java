package lp.dip.CarnetAdresse;

//http://research.jacquet.xyz/teaching/java/sockets-objects/




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class ServeurSocketTCP implements Runnable{
	
	private ServerSocket gestionComClient;
	private Socket comClient;
	private ObjectInputStream in;
	private  ObjectOutputStream  out;
	private String messageEnvoi="";
	private Echantillon echantillon;
	Connect connexion;
	
	public ServeurSocketTCP() throws SQLException
	{
		connexion = new Connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/bddsocket?autoReconnect=true&useSSL=false", "root", "rtlry");
		lancerServeur();
	}
	//public void lancerServeur(int pPort,String pIP)
	public void lancerServeur()
	{
		int pPort=29810;
		
		try {
			this.gestionComClient = new ServerSocket(pPort);
			System.out.println("Le Serveur a démarré sur le port : " + pPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void arreterServeur(){
		try {
			this.gestionComClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attendreClient()
	{
		try {
			
			this.comClient = this.gestionComClient.accept();
			System.out.println("Un client s'est connecté" + this.comClient.getPort() + this.comClient.getLocalPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out = new ObjectOutputStream(this.comClient.getOutputStream());
			in = new ObjectInputStream(this.comClient.getInputStream());
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void deconnecterClient()
	{
		try {
			this.comClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recevoirRequete()
	{
		try {
			System.out.println("Le client a envoyé le message : " + in.readLine());
			try {
				Object messageRecu = in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void envoyerReponse()
	{
		//out.writeObject(comClient);
		try {
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
	while(true) {
		attendreClient();
	//	ajouterClient(client);
	}

		
	}
}

