# Module 12 — Production Deployment Capstone (optional)

## Goal

You've been using Docker since Module 0, but with dev-mode Dockerfiles
(`mvnw spring-boot:run`, `ng serve`) optimized for live-reload, not for
running in production. This capstone upgrades both to production-grade
builds.

## Key concepts

- Multi-stage Docker builds: a "build" stage with the full JDK/Maven or
  Node toolchain, and a slim "runtime" stage that only contains the built
  artifact
- Packaging the Spring Boot app as an executable jar and running it with
  just a JRE (no Maven needed at runtime)
- Building the Angular app for production (`ng build`, minified, no dev
  server) and serving the static files with nginx
- Environment variables for secrets (database password, JWT signing key)
  instead of the hardcoded values used since Module 0
- A production-like `docker-compose.prod.yml` (or profile) that uses the
  new images instead of the dev ones

## Exercise

1. Add `backend/Dockerfile.prod`: stage 1 builds the jar with Maven, stage 2
   copies just the jar into a slim `eclipse-temurin:21-jre` image and runs
   `java -jar app.jar`.
2. Add `frontend/Dockerfile.prod`: stage 1 runs `ng build` with a Node
   image, stage 2 copies the built `dist/` output into an `nginx` image.
3. Create `docker-compose.prod.yml` referencing the two `.prod` Dockerfiles,
   and move the Postgres password / JWT secret into environment variables
   read from a `.env` file (gitignored — see the root `.gitignore` from
   Module 0).
4. Run it:
   ```
   docker compose -f docker-compose.prod.yml up --build
   ```
   and confirm the app works exactly as it did in dev — login, tasks,
   categories — but now running from optimized production images with no
   live-reload.
5. (Bonus) Compare image sizes: `docker images` before vs. after this
   module's changes.

**Done when:** the full stack runs from `docker-compose.prod.yml` using
production-built images, with no secrets hardcoded in any committed file.

This is the last module in the curriculum — from here, natural next steps
are deploying to a real host/cloud provider, adding CI, or extending the
Task Tracker domain with new features using everything you've learned.
