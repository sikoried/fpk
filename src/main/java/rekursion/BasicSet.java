package rekursion;

import java.util.Collection;

public interface BasicSet<T extends Comparable<T>> extends Iterable<T> {
	boolean contains(T e);
	boolean add(T e);
	boolean addAll(Collection<T> c);
}
