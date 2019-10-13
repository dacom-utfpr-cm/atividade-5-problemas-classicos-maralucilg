package Ex1;

public class Writer extends Thread {
	
	SharedResource buffer;
	ReaderWriter rw;
	
	public Writer(SharedResource buffer, ReaderWriter rw) {
		
		this.buffer = buffer;
		this.rw = rw;
	}
	
	@Override
	public void run() {
		
		
		while(true) {
			
			try {
				rw.startWrite();
				System.out.println("Stephen King");
				buffer.incrementar();
				
			} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				rw.endWrite();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	}
}
