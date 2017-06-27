package datenstrukturen;

public class HashMap<K, V> implements Map<K, V> {
	static final int NUM_BINS = 15;

	private static class Entry<K, V> implements Map.Entry<K, V> {
		Entry<K, V> next;

		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
	}

	Entry<K, V>[] entries = (Entry<K, V>[]) new Object[NUM_BINS];

	@Override
	public void put(K key, V value) {
		int bin = key.hashCode() % NUM_BINS;
		if (entries[bin] == null) {
			entries[bin] = new Entry<>(key, value);
			return;
		}

		// suchen...
		Entry<K, V> it = entries[bin], schlepp = null;
		while (it != null) {
			if (key.equals(it.key)) {
				it.value = value;
				return;
			}
			schlepp = it;
			it = it.next;
		}

		schlepp.next = new Entry<>(key, value);
	}

	@Override
	public V get(K key) {
		int bin = key.hashCode() % NUM_BINS;
		if (entries[bin] == null)
			return null;
		Entry<K, V> it = entries[bin];

		// trivialfall: keine Liste!
		if (it.next == null)
			return it.value;

		while (it != null) {
			if (key.equals(it.key))
				return it.value;
			it = it.next;
		}

		return null;
	}
}
