# Danmark mod Madspild 🇩🇰♻️🍲

Velkommen til GitHub-repositoriet for projektet "Danmark mod Madspild". Dette projekt er udviklet af Gruppe 4 (Frederik, Tobias, Sebastian & Peyton) som en del af Obligatorisk opgave 2.Semester Damatiker KEA.

**Github:** [https://github.com/Krymmel-Kaemperne/Madspild](https://github.com/Krymmel-Kaemperne/Madspild)

**Team GitHub Handles:**
*   frederiksrasmus
*   tobiasdosdal
*   PeyHunter
*   SebastianBoel

## Om Projektet

"Danmark mod Madspild" er en webplatform designet til at bekæmpe madspild i Danmark. Platformen sigter mod at:

*   **Informere** forbrugere og virksomheder om omfanget og konsekvenserne af madspild.
*   **Tilbyde konkrete værktøjer** og tips til at reducere madspild i hverdagen og i erhvervslivet.
*   **Forbinde** virksomheder med overskudsmad og velgørenhedsorganisationer, der kan aftage maden.

Målgruppen er bred og inkluderer private forbrugere, fødevarevirksomheder (detailhandel, producenter, restauranter) og velgørenhedsorganisationer (f.eks. fødevarebanker).

## Nøglefunktioner (Baseret på Use Cases)

*   **Forbrugere:**
    *   Se fakta og statistikker om madspild.
    *   Få tips & tricks til madopbevaring og konservering.
    *   Tilmeld dig nyhedsbrev.
    *   Find opskrifter baseret på egne ingredienser ("Køleskaberen").
    *   Se sæsonkalender for frugt & grønt.
*   **Virksomheder:**
    *   Registrer en virksomhedsprofil.
    *   Opret opslag med overskydende mad til donation.
    *   Administrer egne opslag.
*   **Velgørenhedsorganisationer:**
    *   Søg og filtrer efter tilgængelige maddonationer.
    *   Se detaljer om donationer og tag kontakt til virksomheder.

## Teknologioversigt

*   **Backend:** Java med Spring Boot Framework
*   **Database:** MySQL
*   **Frontend:** HTML, CSS
*   **Udviklingsmiljø:** IntelliJ IDEA, Git, GitHub

## Kom Godt i Gang (Udviklingsmiljø)

Følg disse trin for at sætte projektet op lokalt:

1.  **Forudsætninger:**
    *   Java Development Kit (JDK)
    *   MySQL Server
    *   Git
2.  **Klon Repositoriet:**
    ```bash
    git clone https://github.com/Krymmel-Kaemperne/Madspild.git
    cd Madspild
    ```
4.  **Byg Projektet:**
    *   Maven:
        ```bash
        mvn clean install
        ```
5.  **Kør Applikationen:**
    *   Via Maven:
        ```bash
        mvn spring-boot:run
        ```
    *   Eller kør `main`-metoden i din Spring Boot Application klasse fra din IDE.
6.  **Adgang:** Åbn din browser og gå til `http://localhost:9090`
