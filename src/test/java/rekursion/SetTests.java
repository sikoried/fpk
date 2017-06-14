package rekursion;

import org.junit.jupiter.api.Test;
import rekursion.BasicSet;
import rekursion.MergeSort;
import rekursion.TreeSet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetTests {
	@Test
	void testSet() {
		BasicSet<Integer> set = new TreeSet<>();

		int[] a = {4, 2, 1, 3, 6, 5, 7};

		for (int i : a)
			set.add(i);

		for (int i : a)
			assertTrue(set.contains(i));

		assertFalse(set.contains(0));
		assertFalse(set.add(1));

		System.out.println(set);
	}

	@Test
	void testMergeSort() {
		List<Integer> il = Arrays.asList(4, 2, 1, 3, 6, 5, 7);
		System.out.println(il);
		List<Integer> sorted = MergeSort.sort(il);
		System.out.println(sorted);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), sorted);
	}
}
