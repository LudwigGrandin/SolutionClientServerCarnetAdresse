package CarnetAdresseBDD;

public class Principale {
	
	public static Connect conn = new Connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/base_carnet?autoReconnect=true&useSSL=false", "me", "mdp");

	// fonction main, premi�re fonnction lanc�e lors de l'execution
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUI gui = new GUI(500, 500, true, "J'aime le chocolat");
	}
}
