package Ex1;

import java.util.concurrent.Semaphore;

//Prioridade para os escritores

public class ReaderWriterWP extends ReaderWriter{ 
	
	int n_reader = 0;
	int token_writers = 0;
	Semaphore wlock = new Semaphore(1);
	Semaphore barreir = new Semaphore(1); // mutex
	Semaphore lock = new Semaphore(1);
	
	public void startRead( ) throws InterruptedException {
		
		barreir.acquire();
		n_reader++;
		
		if(n_readers == 1) {
			
			barreir.release();
			wlock.acquire();
		}
		
		else {
			
			barreir.release();
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
		
		barreir.acquire();
		token_writers++;
		
		if(token_writers == 1) {
			
			barreir.release();
			wlock.acquire();
		}
		else {
			barreir.release();
		}
		
		lock.acquire();
			
		}
	
	public void endWrite( ) throws InterruptedException {
		
		barreir.acquire();
		token_writers--;
		
		if(token_writers == 0) 
			
			wlock.release();
	
		
		barreir.release();
		lock.release();
		
	}

}
