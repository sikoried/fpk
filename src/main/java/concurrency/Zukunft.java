package concurrency;

import java.util.concurrent.Callable;

public class Zukunft<T> {
	private T rueck;
	private Exception ex;

	private Thread thread;

	public Zukunft(Callable<T> zutun) {
		thread = new Thread(new Runnable() {
			public void run() {
				try {
					// hier passiert die eigentliche Arbeit!
					rueck = zutun.call();
				} catch (Exception e) {
					ex = e;
					e.printStackTrace();
				}
			}
		});

		thread.start();
	}

	public boolean isDone() {
		return !thread.isAlive();
	}

	public T get() throws Exception {
		// warten bis unser Thread fertig ist...
		thread.join();

		// gab es eine Exception? wenn ja: weiterwerfen!
		if (ex != null)
			throw ex;

		return rueck;
	}
}
