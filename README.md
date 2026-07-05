# Learning Java Spring Boot + Angular

A hands-on curriculum for learning full-stack web development with
**Spring Boot** (backend) and **Angular** (frontend), built one module at a
time around a single example app: **Task Tracker**.

## Prerequisites

- **Docker** (Docker Desktop on Mac/Windows, Docker Engine + Compose plugin
  on Linux) — required, everything runs in containers.
- **JDK 21** and **Node.js LTS** — optional, but recommended so your editor
  can give you autocomplete/error-checking.
- **VS Code** — open the repo root folder in VS Code and accept the
  "Install recommended extensions" prompt (`.vscode/extensions.json`) to get
  Java/Spring Boot, Angular, Docker, and YAML support for both `backend/`
  and `frontend/` in one editor.

## Running the stack

From the repo root:

```
docker compose up --build
```

- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- Postgres: `localhost:5432` (db/user/password: `tasktracker` — local
  learning credentials only, see [Module 12](docs/curriculum/12-deployment.md)
  for how real secrets should be handled)

Both `backend/` and `frontend/` are bind-mounted into their containers, so
edits you make on your host machine are picked up automatically (Spring
Boot DevTools restarts the backend, `ng serve` live-reloads the frontend) —
no separate local Java/Node install is required to run the app, only to get
IDE support.

If you'd rather run things without Docker: `cd backend && ./mvnw
spring-boot:run` and `cd frontend && npm start` work too, but you'll need
a local Postgres (or switch the backend's active profile to `h2` — see
`backend/src/main/resources/application.yml`).

## Curriculum

Work through these in order — each module builds on the last and ends with
something concrete you can run and see working.

| # | Module |
|---|---|
| 0 | [Setup](docs/curriculum/00-setup.md) |
| 1 | [Java Fundamentals Refresher](docs/curriculum/01-java-fundamentals.md) |
| 2 | [Spring Boot Basics](docs/curriculum/02-spring-boot-basics.md) |
| 3 | [REST API + In-Memory CRUD](docs/curriculum/03-rest-crud.md) |
| 4 | [Persistence with JPA + PostgreSQL](docs/curriculum/04-persistence-jpa.md) |
| 5 | [Relationships & Domain Modeling](docs/curriculum/05-relationships.md) |
| 6 | [Validation & Error Handling](docs/curriculum/06-validation.md) |
| 7 | [Automated Backend Testing](docs/curriculum/07-backend-testing.md) |
| 8 | [Angular Fundamentals](docs/curriculum/08-angular-fundamentals.md) |
| 9 | [Connecting Angular to Spring Boot](docs/curriculum/09-angular-backend-integration.md) |
| 10 | [Authentication & Authorization](docs/curriculum/10-authentication.md) |
| 11 | [Automated Frontend Testing](docs/curriculum/11-frontend-testing.md) |
| 12 | [Production Deployment Capstone](docs/curriculum/12-deployment.md) (optional) |

## Project layout

```
/
├── backend/   Spring Boot (Java 21, Maven, Spring Boot 3.5.x)
├── frontend/  Angular (standalone components + signals)
├── docs/curriculum/  One doc per module above
└── docker-compose.yml  Runs db + backend + frontend together
```

Backend and frontend packages/folders are added incrementally as each
module needs them, rather than all upfront — the structure is meant to grow
with the curriculum, not be memorized before it's understood.
