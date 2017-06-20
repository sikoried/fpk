package concurrency;

import org.junit.jupiter.api.Test;

class ThreadStates {
	@Test
	void testJoin() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 1 startet...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Thread 1 wurde unterbrochen!");
				}
				System.out.println("Thread ist wieder aufgewacht!");
			}
		});

		t1.start();
		System.out.println(t1.isAlive());

		t1.join();
		System.out.println("t1 ist fertig!");
	}

	@Test
	void testJoinTimeout() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 1 startet...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Thread 1 wurde unterbrochen!");
				}
				System.out.println("Thread ist wieder aufgewacht!");
			}
		});

		t1.start();
		System.out.println(t1.isAlive());

		t1.join(1000);  // Warte aber maximal 1000ms!

		if (t1.isAlive()) {
			System.out.println("Hm, t1 ist immer noch aktiv?");
			t1.interrupt();
			try {
				t1.join();
			} catch (InterruptedException e) {
				System.out.println("Unterbrechung: " + e.toString());
			}
		}

		System.out.println("t1 ist fertig!");
	}
}
