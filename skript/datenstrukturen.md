_Dies ist ein Teil des Skripts zur Lehrveranstaltung [Fortgeschrittene Programmierkonzepte (FPK)](https://github.com/sikoried/fpk) im 2. Semester des Bachelorstudiengangs Wirtschaftsinformatik an der Hochschule Rosenheim._


# Listen und verwandte Datenstrukturen
Eine Liste ist eine sequenzielle Datenstruktur welche (prinzipiell) beliebig lang sein kann.

[`interface List<T>`](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

`interface` [Queue](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
Spezialform der Liste: `remove()` entfernt das erste Element, `add(...)` hängt hinten an. (first in - first out; FIFO) z.B. implementiert durch `LinkedList`

`class` [Stack](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)
Ähnlich einer Liste, jedoch `push` um hinten anzuhängen und `pop` um das letzte Element wieder zu entfernen. (last in - first out; LIFO)

`interface` [Set](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)
Speichert Elemente ohne Duplikate.


# Baum und verwandte Datenstrukturen
Ein Baum ist ebenfalls eine verkettete Datenstruktur, allerdings mit zwei (oder mehr) Nachfolgern pro Containerelement.
Vergleicht man Elemente beim Einfügen, so kann man einen Binären Suchbaum erstellen, bei dem alle Nachfolger auf der linken Seite kleiner sind als das aktuelle Element, und rechts größer.

[`interface Set<T>`](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)
Duplikatfreie Menge von Objekten; effizient z.B. als `TreeSet` implementiert.


# Assoziative Container