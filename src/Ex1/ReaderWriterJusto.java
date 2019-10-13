package Ex1;

import java.util.concurrent.Semaphore;

/* Sem inanição*/

public class ReaderWriterJusto extends ReaderWriter {
	
	int n_reader = 0;
	Semaphore wlock = new Semaphore(1);
	Semaphore barreir = new Semaphore(1); // mutex
	Semaphore fairlock = new Semaphore(1, true);
	
	public void startRead( ) throws InterruptedException {
		
		fairlock.acquire();
		barreir.acquire();
		
		if(n_readers == 0) {
			
			wlock.acquire();
		}
		
		else {
			n_reader++;
			barreir.release();
			fairlock.release();
		}
		
		
	}
	
	public void endRead( ) throws InterruptedException {
		
		barreir.acquire();
		n_readers--;
		
		if(n_readers == 0) {
			
			wlock.release();
		}
		
		barreir.release();
			
		}
	
	public void startWrite( ) throws InterruptedException {
		
		fairlock.acquire();
		wlock.acquire();
		fairlock.release();
		
			
		}
	
	public void endWrite( ) throws InterruptedException {
		
			
			wlock.release();



}
}