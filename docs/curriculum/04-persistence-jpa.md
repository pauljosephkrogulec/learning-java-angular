# Module 4 — Persistence with JPA + PostgreSQL

## Goal

Replace the in-memory `Map` from Module 3 with a real database, using the
Postgres container that's already been running since Module 0.

## Key concepts

- `@Entity`, `@Id`, `@GeneratedValue` — turning a plain class into a database
  table
- Spring Data JPA's `JpaRepository<Task, Long>` — you get `findAll`,
  `findById`, `save`, `deleteById` for free, no SQL written
- `application.yml` profiles (`h2` vs `postgres`) — see
  `backend/src/main/resources/application.yml`, already scaffolded in
  Module 0
- Why data survives restarts now (it didn't in Module 3)

## Exercise

1. Turn `Task` into a JPA `@Entity` (add `@Id`/`@GeneratedValue` to `id`).
2. Delete `InMemoryTaskRepository` and replace it with
   `com.learning.tasktracker.repository.TaskRepository extends
   JpaRepository<Task, Long>`.
3. Update `TaskService`/`TaskController` to use the new repository — the
   HTTP behavior from Module 3 should be unchanged from the outside.
4. With `docker compose up` running (Postgres profile is already the
   default), create a few tasks via the API, then run
   `docker compose restart backend` and confirm the tasks are still there —
   proving they're persisted in Postgres, not in memory.
5. Inspect the rows directly:
   ```
   psql -h localhost -U tasktracker -d tasktracker -c "select * from task;"
   ```

**Done when:** tasks survive a backend restart, and you can see them
directly in the `task` table via `psql`.

Next: [Module 5 — Relationships](05-relationships.md)
