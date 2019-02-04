package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientSocketTCP {
	
	private int portServeur;
	private PrintWriter out;
	private Socket client;
	private BufferedReader in;
	private String ligne;
	
	public clientSocketTCP()
	{	
		
		
	}
	
	public void connecter(int pPort, String pIP)
	{
		this.portServeur=pPort;
		
		try {
			client = new Socket(pIP ,this.portServeur);
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out = new PrintWriter(client.getOutputStream());
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void deconnecter()
	{
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void envoyerRequete(String message)
	{
		out.println(message);
		out.flush();
	}
	
	public boolean recevoirReponse()
	{

		try {
			ligne = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(ligne);

		
		return false;
	}
	
}
