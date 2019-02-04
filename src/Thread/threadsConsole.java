package Thread;

public class threadsConsole implements Runnable {
	
	int compteBanque;
	String nom;
	
	
	public threadsConsole(int pCompteBanque, String pNom)
	{
		this.compteBanque=pCompteBanque;
		this.nom=pNom;
		
	}

	@Override
	public void run() {
		for(int i=0;i<50;i++)
		{
			System.out.println(nom + " = " + compteBanque );
			compteBanque ++;
			
		}
		
	}
	
	

}
