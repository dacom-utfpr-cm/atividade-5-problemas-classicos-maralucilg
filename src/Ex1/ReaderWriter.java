package Ex1;

import java.util.concurrent.Semaphore;

abstract class ReaderWriter {
	
	int n_readers = 0;
	Semaphore barrier = new Semaphore(1); // mutex
	Semaphore wlock = new Semaphore(1);

	public void startWrite() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public void endWrite() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}


	public void startRead() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public void endRead() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
