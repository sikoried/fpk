package concurrency;

import org.junit.jupiter.api.Test;

class SharedResources {
	static class Counter {
		int c = 0;
		int increment(int val) {
			c = c + 1;
			return c;
		}
		synchronized int incrementSyncA(int val) {
			c = c + 1;
			return c;
		}
		int incrementSyncB(int val) {
			synchronized(this) {
				c = c + 1;
				return c;
			}
		}
	}

	@Test
	void testCounter() throws InterruptedException {

		final Counter counter = new Counter();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100000; i++)
					counter.increment(1);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100000; i++) {
					counter.increment(1);
				}
			}
		});

		t1.start(); t2.start();
		t1.join(); t2.join();

		System.out.println(counter.c);
	}
}
