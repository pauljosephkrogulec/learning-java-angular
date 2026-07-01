# Module 7 — Automated Backend Testing

## Goal

Now that there's a real API worth protecting, learn to write automated
tests instead of manually curling endpoints after every change.

## Key concepts

- JUnit 5 basics: `@Test`, assertions
- Mockito: mocking a repository so you can unit-test a service in isolation
- Test slices: `@WebMvcTest` (controller layer + `MockMvc`, no real
  database), `@DataJpaTest` (repository layer against a real — but
  in-memory — database)
- `@SpringBootTest` — a full integration test, used sparingly (slower)
- Why tests use the `h2` profile (fast, disposable) even though the app
  runs on Postgres

## Exercise

1. Unit test: `TaskServiceTest` — mock `TaskRepository` with Mockito, verify
   business logic in `TaskService` (e.g. filtering, mapping to DTOs) without
   touching any real database.
2. Controller slice test: `TaskControllerTest` using `@WebMvcTest` and
   `MockMvc` — assert that posting an invalid task (blank title) returns
   `400` with the error shape from Module 6.
3. Repository slice test: `TaskRepositoryTest` using `@DataJpaTest` (runs
   against H2 automatically) — save a `Category` and a `Task` linked to it,
   reload it, and assert the relationship persisted correctly.
4. One `@SpringBootTest` — boot the whole app and hit `GET /api/tasks`
   end-to-end, just to prove the wiring works together.
5. Run everything:
   ```
   docker compose run --rm backend ./mvnw test
   ```

**Done when:** `./mvnw test` passes for all four tests, and you can explain
the difference between the mocked unit test and the two test slices.

Next: [Module 8 — Angular Fundamentals](08-angular-fundamentals.md)
