package Ex2;

import java.util.concurrent.Semaphore;

abstract class Garfos {
	
	int num_garfos = 0;
	Semaphore[] garfos = null;
	
	public Garfos(int num_garfos) {
		this.num_garfos = num_garfos;
		garfos = new Semaphore[num_garfos];
		
		for(int i = 0; i < num_garfos; i++) {
			
			garfos[i] = new Semaphore(1);
		}
		
	}

	public abstract void comer(int id, String nome);
	public abstract void solta(int id, String nome);

}
