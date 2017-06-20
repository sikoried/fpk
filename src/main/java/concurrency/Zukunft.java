package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class Zukunft<T> {
	T rueck;
	Exception ex;

	CountDownLatch latch = new CountDownLatch(1);

	Zukunft(Callable<T> zutun) {
		new Thread(new Runnable() {
			public void run() {
				try {
					rueck = zutun.call();
				} catch (Exception e) {
					ex = e;
					e.printStackTrace();
				}
				finally {
					latch.countDown();
				}
			}
		}).start();
	}

	T get() throws Exception {
		latch.await();
		if (ex != null)
			throw ex;

		return rueck;
	}
}
