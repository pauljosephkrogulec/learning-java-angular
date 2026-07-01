# Module 9 — Connecting Angular to Spring Boot

## Goal

Wire the two halves of this monorepo together for the first time — your
first true end-to-end full-stack feature.

## Key concepts

- `HttpClient` and `provideHttpClient()` — Angular's way of making HTTP
  calls
- RxJS Observables at a basic level: `.subscribe()`
- CORS — why the browser blocks `localhost:4200` calling `localhost:8080` by
  default, and how to configure the backend to allow it
- Angular Router: list view + detail view
- Reactive forms for the "create task" form

## Exercise

1. Backend: add a CORS configuration (e.g. a `WebMvcConfigurer` bean)
   allowing requests from `http://localhost:4200` to `/api/**`.
2. Frontend: add `provideHttpClient()` to `app.config.ts`.
3. Replace `TaskMockService` from Module 8 with a real `TaskService` that
   calls `GET http://localhost:8080/api/tasks` and `POST
   http://localhost:8080/api/tasks`.
4. Add a route for a task list page and a route for a "new task" page with
   a reactive form (title, priority, due date — matching the validation
   rules from Module 6).
5. Confirm: creating a task through the Angular form causes it to appear in
   the list without a manual page reload, and the data is still there after
   refreshing the browser (proving it round-tripped through Postgres).

**Done when:** you can create and view tasks entirely through the Angular
UI, backed by the real Spring Boot API and Postgres.

Next: [Module 10 — Authentication & Authorization](10-authentication.md)
