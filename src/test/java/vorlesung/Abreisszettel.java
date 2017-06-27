package vorlesung;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Abreisszettel {
	int n;
	Abreisszettel(int n) {
		this.n = n;
	}
	synchronized void countDown() {
		System.out.println("countDown()");
		if (n > 0)
			n = n - 1;

		if (n == 0)
			notifyAll();
	}
	synchronized void await() throws InterruptedException {
		System.out.println("Wait startet!");
		if (n > 0) {
			System.out.println("Noch nicht fertig, warte!");
			wait();
		}
	}


	public static void main(String[] args) throws InterruptedException {
		Abreisszettel a = new Abreisszettel(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Thread startet");
					Thread.sleep(3000);
					System.out.println("Thread fertig");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				a.countDown();
			}
		}).start();

		a.await();
		System.out.println("Programm fertig");
	}
}
