package rekursion;

import java.util.LinkedList;
import java.util.List;

class MergeSort {
	static <T extends Comparable<T>> List<T> sort(List<T> l) {
		// Eine leere oder ein-elementige Liste ist bereits sortiert.
		if (l.size() <= 1)
			return l;

		// Linke und rechte Hälfte jeweils sortieren ("teile")
		List<T> l1 = l.subList(0, l.size()/2);
		List<T> l2 = l.subList(l.size()/2, l.size());

		// Sortierte Teillisten zusammenfügen ("herrsche")
		return merge(sort(l1), sort(l2));
	}

	/**
	 * Verschmelze zwei sortierte Listen zu einer sortierten Liste, in dem jeweils
	 * das kleinere erste Element in die neue Liste aufgenommen wird, und dann alle
	 * verbleibenden durch einen rekursiven Aufruf.
	 *
	 * Diese funktional-rekursive Implementierung ist nicht so effizient wie eine
	 * iterative, aber sie verdeutlicht das Konzept der Rekursion.
	 */
	private static <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {
		// Trivialfälle: eine der beiden zu verschmelzenden Listen ist leer.
		if (l1.size() == 0)
			return l2;
		if (l2.size() == 0)
			return l1;

		// Vergleiche jeweils die ersten Elemente
		List<T> nl = new LinkedList<>();
		if (l1.get(0).compareTo(l2.get(0)) < 0) {
			nl.add(l1.get(0));
			nl.addAll(merge(l1.subList(1, l1.size()), l2));
		} else {
			nl.add(l2.get(0));
			nl.addAll(merge(l1, l2.subList(1, l2.size())));
		}

		return nl;
	}
}
