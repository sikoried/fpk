package datenstrukturen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTests {
	@Test
	void testHashMap() {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < 10; i++)
			map.put(i, i);

		for (int i = 0; i < 10; i++)
			Assertions.assertEquals(i, map.get(i).intValue());

		Assertions.assertNull(map.get(-1));

		System.out.println(map);
	}
}
