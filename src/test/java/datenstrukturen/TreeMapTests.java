package datenstrukturen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeMapTests {
	@Test
	void testTreeMap() {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < 10; i++)
			map.put(i, i);

		for (int i = 0; i < 10; i++)
			Assertions.assertEquals(i, map.get(i).intValue());

		Assertions.assertNull(map.get(-1));

		System.out.println(map);
	}
}
