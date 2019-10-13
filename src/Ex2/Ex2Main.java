package Ex2;

/*
 *   2. Implemente uma solução para o problema do Jantar dos Filósofos que não resulte em impasse (*deadlock*).
 *   
 *   @maralucilg
 * 
 */

public class Ex2Main {

	public static void main(String[] args) {
		Garfos garfos = new ThreadDinner(9);
		new Filosofo(0, " Platão ", garfos).start();
		new Filosofo(1, " Aristoteles ", garfos).start();
		new Filosofo(2, " Thomas Hobbes ", garfos).start();
		new Filosofo(3, " John Bentley ", garfos).start();

	}

}
