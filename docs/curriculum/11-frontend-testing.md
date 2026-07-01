# Module 11 — Automated Frontend Testing

## Goal

Mirror Module 7, but for the Angular side — automated tests instead of
manually clicking through the UI after every change.

## Key concepts

- Jasmine (test framework) + Karma (test runner) — the Angular CLI default,
  used here deliberately instead of migrating to Jest, to avoid extra build
  configuration before you understand what a test runner does
- `TestBed` — Angular's testing utility for configuring a mini test module
- `provideHttpClientTesting()` / `HttpTestingController` — faking HTTP
  responses in tests instead of hitting a real backend
- Component tests vs. service tests

## Exercise

1. Component test: for `TaskListComponent`, render it with a few fake tasks
   and assert the right number of list items appear, and that a "done" task
   shows the expected styling/marker.
2. Service test: for the real `TaskService` (from Module 9), use
   `HttpTestingController` to fake the backend response for `GET
   /api/tasks` and assert the service parses it correctly — no real network
   call.
3. Add at least one test for the login form's validation (e.g. submit
   button disabled until both fields are filled).
4. Run everything:
   ```
   docker compose run --rm frontend npx ng test --watch=false --browsers=ChromeHeadless
   ```

**Done when:** `ng test` passes for all the tests above, and you can explain
why the service test doesn't need Docker/Postgres/the real backend running.

Next: [Module 12 — Production Deployment Capstone](12-deployment.md)
