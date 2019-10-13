package Ex2;

import java.util.concurrent.Semaphore;

public class ThreadDinner extends Garfos {
	
	Semaphore semaphore = new Semaphore(1); // mutex
	int tokens = 0;

	public ThreadDinner(int num_garfos) {
		super(num_garfos);
	}
	
	@Override
	public void comer(int id, String nome) {
		try {
			semaphore.acquire();
			tokens++;
			if(tokens == num_garfos) {
				semaphore.release();
				Thread.sleep(1000);
			}
			else
			{
				semaphore.release();
			}
			garfos[id].acquire();
			garfos[(id+1) % num_garfos].acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}
	
	@Override
	public void solta(int id, String nome) {
		try {
			semaphore.acquire();
			tokens--;
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		garfos[id].release();
		garfos[(id+1) % num_garfos].release();
	}
	
	

}
