package threads;

import org.junit.jupiter.api.Test;

public class KochauftragTests {
	@Test
	void testKochauftrag() {
		Kochauftrag k1 = new Kochauftrag("Vorspeise", 3);
		Kochauftrag k2 = new Kochauftrag("Hauptspeise", 6);
		Kochauftrag k3 = new Kochauftrag("Dessert", 4);

		k1.kochen();
		k2.kochen();
		k3.kochen();

		System.out.println("Alles fertig!");
	}

	@Test
	void testKochauftragThread() {
		KochauftragThread k1 = new KochauftragThread("Vorspeise", 3);
		KochauftragThread k2 = new KochauftragThread("Hauptspeise", 6);
		KochauftragThread k3 = new KochauftragThread("Dessert", 4);

		k1.start();
		k2.start();
		k3.start();

		System.out.println("Alles fertig!");
	}
}
