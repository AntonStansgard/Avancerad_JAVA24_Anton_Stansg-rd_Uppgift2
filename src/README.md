
# Hanteringssystem för studenter

Detta Java-program är ett enkelt hanteringssystem för att lägga till, söka efter, visa, spara och ladda studentposter. Programmet använder Singleton-mönstret för att säkerställa att endast en instans av hanteringssystemet existerar.
___
## Funktioner

- Lägg till student

Lägger till en ny student med ID, namn och betyg.
 

- Säkerställer att varje student-ID är unikt.


- Sök efter student

Sök efter en student med hjälp av deras ID.


- Visa alla studenter

Visar alla studenter i systemet.
 
 
- Spara till fil


Sparar alla studenter till en fil (students.txt) i formatet ID,Namn,Betyg.
 

- Ladda från fil

Läser in studenter från en fil och visar dem i systemet.

___
## Användning
1. Kom igång

Kör programmet med java Main.
2. Navigera i menyn

När programmet körs, välj mellan följande alternativ i huvudmenyn:
- Lägg till en student
- Ladda studenter från fil
- Visa alla studenter
- Spara alla studenter till fil
- Sök efter en student
- Avsluta
3. Filformat

Filen students.txt lagrar varje student på en separat rad i formatet:
ID,Namn,Betyg
___
## Krav
Java SE 8 eller senare.

En textredigerare eller IDE som stödjer Java (t.ex. IntelliJ )
___
## Kodstruktur
### Klasser
1. Student
- Representerar en enskild student med följande attribut:
id: Studentens ID.
name: Studentens namn.
grade: Studentens betyg.
2. StudentManager
- Hanterar studentdatan med hjälp av en HashMap där ID är nyckeln och Student-objektet är värdet.
Använder Singleton-mönstret för att säkerställa en enda instans av hanteringssystemet.
3. StudentUtils
- Hjälpklass för att spara och ladda studentposter till/från en fil.

4. Main
- Huvudklassen som innehåller programets meny.
