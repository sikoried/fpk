package rekursion;

import java.util.*;

public class TreeSet<T extends Comparable<T>> implements BasicSet<T> {
	private class Element {
		Element(T e) { elem = e; }
		T elem;
		Element links;
		Element rechts;

		boolean contains(T e) {
			return e.equals(elem)
					|| (links != null  && links.contains(e))
					|| (rechts != null && rechts.contains(e));
		}

		boolean add(Element e) {
			int c = e.elem.compareTo(elem);

			if (c == 0)
				return false;
			if (c < 0) {
				if (links != null)
					return links.add(e);
				else {
					links = e;
					return true;
				}
			} else {
				if (rechts != null)
					return rechts.add(e);
				else {
					rechts = e;
					return true;
				}
			}
		}

		@Override
		public String toString() {
			// Präfixnotation
			return "(" + elem + " "
					+ (links == null ? "-" : links) + " "
					+ (rechts == null ? "-" : rechts)
					+ ")";
		}
	}

	private Element root;

	@Override
	public boolean contains(T e) {
		if (root == null)
			return false;
		else
			return root.contains(e);
	}

	@Override
	public boolean add(T e) {
		if (root == null) {
			root = new Element(e);
			return true;
		} else
			return root.add(new Element(e));
	}

	@Override
	public String toString() {
		if (root == null) {
			return "-";
		} else
			return root.toString();
	}

	@Override
	public boolean addAll(Collection<T> c) {
		boolean change = false;
		for (T e : c)
			change = change || add(e);
		return change;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Stack<Element> agenda = new Stack<>();

			// statischer Initialisierungsblock
			{
				if (root != null)
					agenda.push(root);
			}

			@Override
			public boolean hasNext() {
				return agenda.size() > 0;
			}

			@Override
			public T next() {
				Element e = agenda.pop();
				if (e.links != null)
					agenda.push(e.links);
				if (e.rechts != null)
					agenda.push(e.rechts);

				return e.elem;
			}
		};
	}
}
