package Ex1;

/*
 * 1. Implemente e teste duas soluções para o problema dos Leitores-Escritores usando semárofos ou monitores que:
   * 
   * não cause inanição (*starvation*) de leitores ou escritores.
   * priorize os escritores.
   * 
   * @maralucilg
 */

public class Ex1Main {

	public static void main(String[] args) {
		
		SharedResource buffer = new SharedResource();
		ReaderWriter rw = new ReaderWriterJusto();
		new Writer(buffer, rw).start();
		new Reader(buffer, rw).start();

	}

}
