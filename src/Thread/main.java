package Thread;

//import threads.threadsConsole;

public class main {

	public static void main(String[] args) {
		
		threadsConsole cb= new threadsConsole(0, "CompteCheque");
		
		System.out.println("Coucou");
		Thread t = new Thread(cb);
		Thread t2 = new Thread(new threadsConsole(10, "LIVA"));
		t.start();
		t2.start();
		
		

	}

}
