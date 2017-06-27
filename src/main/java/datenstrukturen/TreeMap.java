package datenstrukturen;


public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	private static class Entry<K extends Comparable<K>, V> implements Map.Entry<K, V>{
		K key;
		V value;

		Entry<K, V> left;
		Entry<K, V> right;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof Entry))
				return false;
			return key.equals(((Entry<?, ?>) o).key);  // wildcard! sonst unchecked cast
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "(" + key + ", " + value + ") " +
					(left != null ? left : "") +
					(right != null ? right : "");
		}
	}

	private Entry<K, V> root = null;

	@Override
	public String toString() {
		if (root == null)
			return "";
		else
			return root.toString();
	}

	@Override
	public void put(K key, V value) {
		if (root == null) {
			root = new Entry<>(key, value);
			return;
		}

		Entry<K, V> it = root, schlepp = null;
		int comp = 0;
		while (it != null) {
			comp = key.compareTo(it.getKey());
			if (comp == 0) {
				it.value = value;
				return;
			}
			schlepp = it;
			it = comp < 0 ? it.left : it.right;
		}

		Entry<K, V> e = new Entry<>(key, value);
		if (comp < 0)
			schlepp.left = e;
		else
			schlepp.right = e;
	}

	@Override
	public V get(K key) {
		Entry<K, V> it = root;
		while (it != null) {
			int comp = key.compareTo(it.getKey());
			if (comp == 0)
				return it.getValue();
			else if (comp < 0)
				it = it.left;
			else
				it = it.right;
		}

		return null;
	}
}
