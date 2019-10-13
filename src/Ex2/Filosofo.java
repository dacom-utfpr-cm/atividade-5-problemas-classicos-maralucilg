package Ex2;

import java.util.Random;

public class Filosofo extends Thread {
	
	int id = 0;
    String nome = "";
	Garfos garfos;

	
	Filosofo(int i,  String nome, Garfos garfos)
	{
		this.id = i;
		this.nome = nome;
		this.garfos = garfos;

	}
	
	@Override
	public void run() {
		
		while(true) {
        garfos.comer(id, nome); 
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(nome + id + "peguei os garfos");
        } catch (Exception e) {
        	e.printStackTrace();
        }
           garfos.solta(id, nome);

		}
		
		
	}
}

