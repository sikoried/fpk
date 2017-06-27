package vorlesung;

import org.junit.jupiter.api.Test;

public class SharedResources {
	static class Counter {
		Integer c = 0;

		int increment(int val) {
			synchronized (c) {
				c = c + val;
				return c;
			}
		}
	}

	@Test
	void testCounter() throws InterruptedException {
		Counter c = new Counter();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++)
					c.increment(1);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++)
					c.increment(1);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(c.c);
	}
}
