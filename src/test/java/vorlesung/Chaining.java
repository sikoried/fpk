package vorlesung;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class Chaining {
	@Test
	void testJoinChain() throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf =  CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread 1 startet");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1 fertig");
			return "Hallo Welt";
		}).thenApply(new Function<String, String>() {
			@Override
			public String apply(String s) {
				System.out.println("Thread 2 laeuft");
				return s.toUpperCase();
			}
		});

		System.out.println("Warte auf Future");

		System.out.println("...sie ist eingetroffen:" + cf.get());
	}
}
