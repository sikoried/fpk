package concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class Chaining {
	@Test
	void testJoinChain() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				System.out.println("Thread 1 startet");
				Thread.sleep(1000);
				System.out.println("Thread 1 ist fertig");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			System.out.println("Thread 2 wartet auf Thread 1");
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 3");
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	@Test
	void testCompletableFutureChain() throws ExecutionException, InterruptedException {
		CompletableFuture<?> cf = CompletableFuture.runAsync(() -> {
			System.out.println("Thread 1 startet");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1 ist fertig");
		}).thenRun(() -> {
			System.out.println("Thread 2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 2 ist fertig");
		});

		System.out.println("Warte auf Future...");
		cf.get();
		System.out.println("Fertig");
	}

	@Test
	void testChainedFutures1() throws ExecutionException, InterruptedException {
		Future<String> f1 = CompletableFuture.supplyAsync(() -> "Ergebnis");

		String erg1 = f1.get();
		Future<String> f2 = CompletableFuture.supplyAsync(() -> erg1.toUpperCase());

		System.out.println(f2.get());
	}

	@Test
	void testChainedFutures2() throws ExecutionException, InterruptedException {
		Future<String> f = CompletableFuture.supplyAsync(() -> "Ergebnis")
				.thenApply(s -> s.toUpperCase());

		System.out.println(f.get());
	}
}
