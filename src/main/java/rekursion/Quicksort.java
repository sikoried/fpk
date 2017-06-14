package rekursion;

import java.util.Comparator;
import java.util.Random;

final class Quicksort {
	/**
	 * Generische Implementierung von Quicksort.
	 * @param array Feld mit Datenwerten (nicht null)
	 * @param c Comparator um die Elemente vergleichen zu können
	 */
	static <T> void sort(T[] array, Comparator<T> c) {
		// Trivialfälle abfangen
		if (array == null || array.length == 0){
			return;
		}

		quicksort(array, 0, array.length - 1, c);
	}

	/**
	 * Sortiere das Teilarray von ... mit (Indizes) mit dem Komparator.
	 */
	private static <T> void quicksort(T[] array, int von, int mit, Comparator<T> c) {
		int i = von, j = mit;
		// Pivot ist erstmal das mittlere Element
		T pivot = array[von + (mit-von)/2];

		// Solange Elemente tauschen, bis der Pivot erreicht ist
		while (i <= j) {
			// Solange links kleiner ist, weiter nach rechts gehen.
			while (c.compare(array[i], pivot) < 0)
				i++;

			// Solange rechts grösser ist, weiter nach links gehen.
			while (c.compare(array[j], pivot) > 0)
				j--;

			// Jetzt haben wir u.U. links ein Element das nach rechts muss
			// und umgekehrt-- tauschen und Indizes weiterbewegen.
			if (i <= j)
				swap(array, i++, j--);
		}

		// Rekursion: Jetzt links und rechts separat sortieren.
		if (von < j)
			quicksort(array, von, j, c);
		if (i < mit)
			quicksort(array, i, mit, c);
	}

	private static <T> void swap(T[] array, int i, int j) {
		T h = array[i];
		array[i] = array[j];
		array[j] = h;
	}

	/**
	 * Erzeuge ein beliebig grosses Array von Integerwerten.
	 */
	static Integer[] random(long n) {
		return new Random().ints(n, Integer.MIN_VALUE, Integer.MAX_VALUE)
				.boxed()
				.toArray(Integer[]::new);
	}
}
