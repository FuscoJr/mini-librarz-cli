# Mini Bibnliothek (Terminal Programm)

Beschreibung:
Dieses Programm ist eine einfache Konsolenanwendung zur Verwaltung einer kleinen Bibliothek.
Benutzer können Items (z.B. Bücher oder Spiele) einsehen, ausleihen und zurückgeben.
Das Personal kann zusätzlich neue Items hinzufügen, entfernen und Statistiken einsehen.

Funktionen:
Allgemeine Benutzer:
- Verfügbare Items einsehen
- Items ausleihen
- Items zurückgeben

Personal:
- Neue Items hinzufügen
- Items entfernen
- Einsicht in aktuell ausgeliehene Items und deren Benutzer
- Statistiken anzeigen

Technische Umsetzung
Das Programm nutzt:
- Klassen und Objekte
- ArrayList zur Speicherung der Items
- Schleifen für das Menü
- Exception Handling für Benutzereingaben
- Kapselung (private Attribute + Getter/Setter)

Ausführen:
    - Java Version 17 oder höher.
    - Programm über die Konsole starten.
    - Menüoption auswählen. (Zugriffsmodus)
        - Benutzer
            Ermöglicht das Einsehen, Ausleihen und Zurückgeben von Items.
            Benutzer werden über einen Name identifiziert.
            Wenn beim Ausleihen eines Items einen neuer Name eingegeben wird, erstellt das System automatisch einen neuen Benutzer.
        - Personal
            Ermöglicht zusätzlich Verwaltungsfunktionen wie das Hinzufügen oder Entfernen von Items sowie Statistiken.
            "Für den Zugriff auf den Personal-Modus wird einen PIN benötigt.
            Standard PIN: 1234"  

Starten des Programms
Das Programm wird über die Konsole gestartet und zeigt ein Menü mit verschiedenen Optionen.

License: MIT
