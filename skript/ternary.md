# Der ternäre `?` Operator

Der ternäre `?` Operator ist ähnlich einem `if-else` Block, mit dem Unterschied, dass er in **Zuweisungen** oder `return`-Anweisungen verwendet wird.
Der Vorteil des `?` Operators ist die kompakte Schreibweise.
Der Nachteil des `?` Operators ist ebenfalls die kompakte Schreibweise: Er kann, ungünstig eingesetzt, die Lesbarkeit des Programms beeinträchtigen.
Der Operator ist *ternär*, besteht also aus drei Komponenten; die Syntax lautet `Bedingung ? Wahr-Wert : Falsch-Wert`.
Wichtig ist: die `: ...` Klausel ist erforderlich, wohingegen `else` bei `if` optional ist.

Beispiel zur Zuweisung:
```java
// Als if-else Block
String s1;
if (bedingung) {
    s1 = "Bedingung ist wahr";
} else {
    s1 = "Bedingung ist falsch";
}

// oder kompakter:
String s2 = bedingung ? "Bedingung ist wahr" : "Bedingung ist falsch";

// oft wie folgt eingerückt um Lesbarkeit zu verbessern:
String s3 = bedingung 
    ? "Bedindung ist wahr"
    : "Bedingung ist falsch";
```

Beispiel zu `return`-Anweisung:
```java
// Bedingte Rückgabe
if (bedingung) {
    return "Berechnung erfolgreich";
} else {
    return "Berechung fehlgeschlagen";
}

// oder kompakter:
return bedingung ? "Berechnung erfolgreich" : "Berechnung fehlgeschlagen";
```

Prinzipiell gilt: Jede `?`-Anweisung kann auch mit `if-else` ausgedrückt werden.
Der umgekehrte Fall nur, wenn es sich um eine bedingte Zuweisung oder Rückgabe handelt.
