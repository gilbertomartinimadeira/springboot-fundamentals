# Copilot Instructions

- This is a Spring Boot project using Java, Maven, and MariaDB.
- Package root: `crossmade.example`.
- Use constructor injection over field injection unless explicitly asked otherwise.
- Database schema/seed data lives in `src/main/resources/schema.sql` and `data.sql`.
- Profiles: `application-dev.properties` is the dev profile, activated via `--spring.profiles.active=dev`.