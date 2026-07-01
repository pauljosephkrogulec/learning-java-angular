# Module 0 — Setup

## Goal

Get the whole stack (database + backend + frontend) running on your machine
via Docker, before writing any application code.

## Prerequisites

- **Docker** (Docker Desktop on Mac/Windows, Docker Engine + Compose plugin on
  Linux) — required. Everything runs inside containers.
- **JDK 21** and **Node.js LTS** — optional, but recommended so your editor
  (IntelliJ IDEA for the backend, VS Code for the frontend) can give you
  autocomplete and error-checking. You will not use these to *run* the app;
  Docker handles that.

## Install checklist

1. Install Docker and confirm it works:
   ```
   docker --version
   docker compose version
   ```
2. (Optional but recommended) Install a JDK and Node so your IDE has
   something to point at:
   ```
   java -version   # expect 21.x
   node -v          # expect a current LTS
   ```
3. Clone this repo and run the whole stack from the repo root:
   ```
   docker compose up --build
   ```

## What you should see

- In the terminal: Postgres becomes healthy, then the backend logs show the
  Spring Boot startup banner and "Started TasktrackerApplication" with no
  errors, then the frontend logs show the Angular dev server compiled
  successfully.
- Open `http://localhost:4200` in a browser — you should see the default
  Angular welcome page.
- Open `http://localhost:8080` — you'll get a 404 (expected — there are no
  endpoints yet, that's Module 2).
- Connect to Postgres from your host to confirm it's reachable:
  ```
  psql -h localhost -U tasktracker -d tasktracker   # password: tasktracker
  ```

## Try the live-reload loop

With `docker compose up` still running, open `frontend/src/app/app.html` and
change the title text, save, and watch the browser at `localhost:4200`
update automatically — `ng serve` picks up saved file changes right away, no
extra step needed.

The backend is a bit different: Spring Boot DevTools only restarts the app
when the compiled `.class` files change, not the raw `.java` source. If
you're using an IDE like IntelliJ IDEA with "build project automatically"
enabled, saving a `.java` file recompiles it immediately and DevTools picks
it up. If you're editing with a plain text editor (or VS Code without that
auto-build behavior), you need to trigger the recompile yourself after
saving:

```
docker compose exec backend ./mvnw -q compile -o
```

Try it: open
`backend/src/main/java/com/learning/tasktracker/TasktrackerApplication.java`,
add a `System.out.println("hello")` in `main`, save, run the command above,
and watch `docker compose logs backend` show a restart and print your line.

If both of those work, your environment is ready — move on to
[Module 1](01-java-fundamentals.md).
