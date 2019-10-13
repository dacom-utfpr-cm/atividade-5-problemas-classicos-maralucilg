package Ex1;

class Reader extends Thread {
	
	SharedResource buffer;
	ReaderWriter rw;
	
	public Reader(SharedResource buffer, ReaderWriter rw) {
		
		this.buffer = buffer;
		this.rw = rw;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				rw.startRead();
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + buffer.getBuffer());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
		        try {
			        rw.endRead();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}

}
}
