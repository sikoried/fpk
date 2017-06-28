# Fortgeschrittene Programmierkonzepte (FPK)

_Entwurf zur neuen Lehrveranstaltung im 2. Semester des Bachelorstudiengangs Wirtschaftsinformatik an der Hochschule Rosenheim._

# Inhalt

0. Git und IntelliJ
1. Klassen und Vererbung
2. Annotationen und das Testframework [JUnit](http://junit.org/junit5/docs/current/user-guide/)
3. Interfaces, abstrakte Basisklassen (ABC) und Reflection
    - Fallstudie: Zustandsmodellierung eines endlichen Automatens mit einer abstrakten Basisklasse
    - Factory Pattern als Kapselung der Instanzenerstellung
4. Container, Iteratoren und Generics
    1. Liste
        - Allgemeine Beschreibung (`add`, `remove`, `get`)
        - Realisierung einer `ArrayList`
        - Einführung in Generics
        - Effizientere ArrayList durch blockweise Allokation
        - Einfach verkettete Liste (`LinkedList`)
    2. Iteration
        - Wiederholung: `for`-Iteration auf Array
        - `for`-Iteration auf Liste: Ineffizient! -> `while` mit "Iterator"
        - Abstraktion in den Iterator; Iterator steht "zwischen" den Elementen
            - Iterator als DesignPattern -> UML
            - Iterator als innere Klasse
    2. Map
        - Nicht-sequenzieller Zugriff: Gib mir Element mit Eigenschaft _X_
        - Konkrete StudentenMap, mit `get(int matr)`
        - Abstraktion 1: `Predicate` -> allgemeine `get(Predicate)`
        - Abstraktion 2: `Map<K, V>.{put,get}`
        - Implementierung als Liste von `Map.Entry<K, V>`
        - Iterator -> sequenzieller Zugriff auf entryset/keyset/valueset
    3. Set
        - Via LinkedList und Duplikatkontrolle -> zu aufwaendig!
        - Via BinBaum (TreeSet)
            - Insert
            - Contains
            - Remove
        - Iteration erfordert Agenda! Tiefen- (DFS) und Breitensuche (BFS)
5. Rekursion
    - Einfache Beispiele: Addition, Modulo, Fakulät, Fibonacci (`for` bzw. `while` Formulierung nach Rekursion)
    - Rekursion auf Tree (`contains`, `toString`)
    - Mergesort
6. Threading 1: Basics
    - Was ist nebenläufige Ausführung
    - Realisierung in Java: `Thread` oder `Runnable`
    - Grundlegende Synchronisation
        + Warten auf Terminierung? 
        + Aktives Warten (`isAlive`)
        + Passives Warten mit `join` (einzelne Threads), und `CountDownLatch` (mehrere Threads oder Jobs)
    - Rückgabe von Ergebnissen bei `Runnable` via Instanzvariable
    - Besser: `Callable` und `Future`, und der `ExecutorService`
7. Threading 2: Zeitliche oder resourcenbedingte Abhängigkeiten
    - Sequenzielle Abhängigkeiten: Chaining (`CompletableFuture`)
    - Resourcen: Synchronisierung mit `synchronized`, `wait`, und `notifyAll`
    - Fallstudie: Erzeuger-Verbraucher-Problem
9. Datenstrukturen in der Gegenüberstellung: List, Set, Map.
    - Konzeptioneller Aufbau (Verlinkung im Speicher?)
    - Realisierung einer `HashMap` via `hashCode` und `equals`
    - Realisierung einer `TreeMap` via Binärbaum und `Comparable` als Bound (Generics)
