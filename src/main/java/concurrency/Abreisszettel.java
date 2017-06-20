package concurrency;

class Abreisszettel {
	volatile Integer n;
	Abreisszettel(int n) {
		this.n = n;
	}

	synchronized void countDown() {
		if (n > 0)
			n = n - 1;

		if (n == 0)
			notifyAll();
	}

	synchronized void await() throws InterruptedException {
		if (n > 0)
			wait();
	}
}
