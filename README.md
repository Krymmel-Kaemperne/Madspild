# Danmark mod Madspild 🇩🇰♻️🍲

Velkommen til GitHub-repositoriet for projektet "Danmark mod Madspild". Dette projekt er udviklet af Gruppe 4 (Frederik, Tobias, Sebastian & Peyton) som en del af [Indsæt kursus/formål her, f.eks. et studieprojekt].

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
*   **Database:** MySQL (Antaget baseret på feasibility study noter)
*   **Frontend:** HTML, CSS, JavaScript (Antaget standard webteknologier)
*   **Udviklingsmiljø:** IntelliJ IDEA, Git, GitHub
*   **Byggeværktøj:** [Maven/Gradle - specificer hvis relevant]

## Kom Godt i Gang (Udviklingsmiljø)

Følg disse trin for at sætte projektet op lokalt:

1.  **Forudsætninger:**
    *   Java Development Kit (JDK) [Angiv version, f.eks. 17 eller nyere]
    *   [Maven/Gradle - specificer hvis relevant]
    *   MySQL Server
    *   Git
2.  **Klon Repositoriet:**
    ```bash
    git clone https://github.com/Krymmel-Kaemperne/Madspild.git
    cd Madspild
    ```
3.  **Database Setup:**
    *   Opret en lokal MySQL database ved navn `[indsæt_database_navn_her]`.
    *   Konfigurer databaseforbindelsen i `src/main/resources/application.properties` (eller `.yml`):
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/[indsæt_database_navn_her]
        spring.datasource.username=[dit_db_brugernavn]
        spring.datasource.password=[din_db_adgangskode]
        spring.jpa.hibernate.ddl-auto=update # Eller create/validate afhængigt af behov
        ```
4.  **Byg Projektet:**
    *   Hvis Maven:
        ```bash
        mvn clean install
        ```
    *   Hvis Gradle:
        ```bash
        ./gradlew build
        ```
5.  **Kør Applikationen:**
    *   Via Maven:
        ```bash
        mvn spring-boot:run
        ```
    *   Via Gradle:
        ```bash
        ./gradlew bootRun
        ```
    *   Eller kør `main`-metoden i din Spring Boot Application klasse fra din IDE.
6.  **Adgang:** Åbn din browser og gå til `http://localhost:8080` (eller den port, applikationen kører på).

## Brug

Når applikationen kører:

*   Besøg hjemmesiden for at udforske de forskellige sektioner (Fakta, Tips, Køleskaber, Sæsonkalender).
*   Virksomheder kan oprette en profil og efterfølgende logge ind for at oprette donationer.
*   Velgørenhedsorganisationer kan [specificer login/søgeproces her] for at finde donationer.

## Screenshots / Demo

*(Indsæt gerne et par screenshots af brugergrænsefladen her for at give et visuelt indtryk)*

![Eksempel Screenshot 1](link/til/screenshot1.png)
![Eksempel Screenshot 2](link/til/screenshot2.png)

## Bidrag

Vi modtager gerne bidrag! Hvis du vil hjælpe med at forbedre projektet:

1.  Fork dette repository.
2.  Opret en ny branch (`git checkout -b feature/AmazingFeature`).
3.  Lav dine ændringer.
4.  Commit dine ændringer (`git commit -m 'Add some AmazingFeature'`).
5.  Push til din branch (`git push origin feature/AmazingFeature`).
6.  Åbn en Pull Request.

Du er også velkommen til at oprette et Issue, hvis du finder en fejl eller har et forslag.

## Licens

[Angiv licens her - f.eks. MIT License. Hvis ingen licens er valgt, kan du skrive "Ingen licens specificeret endnu."]

---

Husk at udfylde de steder, hvor der står `[Indsæt ... her]` eller lignende, og tilføj eventuelt screenshots. Held og lykke med projektet!
