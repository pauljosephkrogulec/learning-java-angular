# Module 3 — REST API + In-Memory CRUD

## Goal

Build a full CRUD API for `Task` before touching a real database, so REST
conventions are the only new thing you're learning.

## Key concepts

- HTTP verbs and what they mean: GET (read), POST (create), PUT (update),
  DELETE (remove)
- HTTP status codes: 200 (OK), 201 (Created), 204 (No Content), 404 (Not
  Found)
- `@PathVariable` vs. `@RequestParam` vs. `@RequestBody`
- `ResponseEntity<T>` for controlling status codes explicitly
- A simple in-memory repository class wrapping a `Map<Long, Task>`

## Exercise

1. Create a proper `Task` class (`id`, `title`, `done`) in
   `com.learning.tasktracker.model`.
2. Create `com.learning.tasktracker.repository.InMemoryTaskRepository` — a
   `@Repository` bean wrapping a `Map<Long, Task>` with an
   `AtomicLong`-based id generator, exposing `findAll`, `findById`, `save`,
   `deleteById`.
3. Update `TaskController` to expose full CRUD backed by the repository:
   - `GET /api/tasks` → 200 + list
   - `GET /api/tasks/{id}` → 200 + task, or 404 if missing
   - `POST /api/tasks` → 201 + created task
   - `PUT /api/tasks/{id}` → 200 + updated task, or 404
   - `DELETE /api/tasks/{id}` → 204, or 404
4. Save a Postman/Insomnia collection (or a `.http` file for your IDE) into
   `backend/api-requests/` exercising every endpoint, and commit it.

**Done when:** you can create, read, update, and delete tasks through the
API with the correct status code every time, verified with your saved
request collection.

Next: [Module 4 — Persistence with JPA + PostgreSQL](04-persistence-jpa.md)
