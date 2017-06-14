package rekursion;

import java.util.Arrays;

public class Rekursion {
	static int mult(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		else
			return mult(a, b, 1);

	}

	private static int mult(int a, int b, int erg) {
		if (a == 1)
			return erg;
		else
			return mult(a - 1, b, erg + b);
	}

	static <T> int suche(T[] a, T g) {
		return suche(a, g, 0);
	}

	private static <T> int suche(T[] a, T g, int i) {
		if (a.length == 0)
			return -1;

		if (a[0].equals(g))
			return i;

		return suche(Arrays.copyOfRange(a, 1, a.length - 1), g, i + 1);

	}
}
