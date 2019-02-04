package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocketTCP implements Runnable{
	
	private ServerSocket gestionComClient;
	private Socket comClient;
	private BufferedReader in;
	private PrintWriter out;
	private String messageRecu="", messageEnvoi="";
	
	public ServeurSocketTCP()
	{
		
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
			out = new PrintWriter(this.comClient.getOutputStream());
			in = new BufferedReader(new InputStreamReader(this.comClient.getInputStream()));
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
			//messageRecu = in.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void envoyerReponse()
	{
		out.println("Code 0 : OK");
		out.flush();
	}
	@Override
	public void run() {
		this.attendreClient();
		this.envoyerReponse();
		this.deconnecterClient();
		
	}
}

