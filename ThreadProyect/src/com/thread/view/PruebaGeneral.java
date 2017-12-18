
package com.thread.view;


public class PruebaGeneral extends Thread {

	public static void main(String[] args) throws Throwable {
		PruebaGeneral pruebas = new PruebaGeneral();
		pruebas.start();
		for (int i = 0; i < 300; i++) {

			pruebas.sleep(2500);
			System.out.println(i);
		}

		pruebas.finalize();

	}

}

class Prueba1 {

	private volatile boolean flag = true;
	private static Thread th1;
	private static Thread th2;
	
	private void stopRunning() {
		flag = false;
	}

	public static void main(String[] args) throws InterruptedException {
		th1 = new Thread();
		th2 = new Thread();
		th1.start();
		System.out.println("Iniciamos el primer Thread");
		for (int i = 0; i < 15; i++) {
			Thread.sleep(1000);
			System.out.println(i);
			if (i == 5) {
				System.out.println("Ahora lo detenemos 6,5 segundos");
				Thread.sleep(6500);
			}

			if (i == 10) {
				th1.join(6500);
				System.out.println("Inicio del segundo Thread en la condición igual a 10");
				th2.start();
				for(int j = 100; j < 150; j++ ) {
					th2.sleep(700);
					System.out.println(j);
				}
				System.out.println("Terminó el segundo Thread");
				
			}

		}

	}
}




class RunMethod implements Runnable{

	@Override
	public void run() {
		Runnable r = () -> {System.out.println("Rabbit");};
		r.run();
		
	}
	
	public static void main(String[] args) {
		RunMethod rm = new RunMethod();
		rm.run();

	}
	
}


class RunnableWithoutImplements{
	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i);					
				}
			}
			
		};
		
		r.run();
	}
}