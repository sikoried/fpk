package vorlesung;

import org.junit.jupiter.api.Test;

public class ThreadStates {
	@Test
	void testJoin() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1 startet");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Unterbrechung!");
				}
				System.out.println("Thread 1 ausgeschlafen");
			}
		});

		System.out.println(t1.isAlive());

		t1.start();
		System.out.println("Thread -> ready");
		System.out.println(t1.isAlive());


		try {
			t1.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (t1.isAlive()) {
			System.out.println("Habe gewartet, aber nicht fertig!");
			t1.interrupt();

			System.out.println(t1.isAlive());

			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
