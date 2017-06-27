package datenstrukturen;

public interface Map<K, V> {
	void put(K key, V value);
	V get(K key);

	interface Entry<K, V> {
		K getKey();
		V getValue();
	}
}
