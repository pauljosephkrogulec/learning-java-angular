# Module 8 — Angular Fundamentals

## Goal

Learn Angular in isolation, with hardcoded data — no HTTP calls yet — so you
can focus entirely on how Angular itself works before connecting it to the
real backend in Module 9.

## Key concepts

- Standalone components (no NgModules — this project uses the modern
  Angular default throughout)
- Templates: interpolation (`{{ }}`), property/event bindings
- Control flow in templates: `@for`, `@if`
- `@Input()` / `@Output()` — passing data down, emitting events up
- Services + dependency injection (Angular's DI is conceptually the same
  idea as Spring's, applied to the frontend)
- Signals: `signal()`, reading/writing reactive state

## Exercise

1. Generate a `Task` interface (`id`, `title`, `done`) and a
   `TaskListComponent` (`ng generate component task-list`).
2. Create a `TaskMockService` (`@Injectable`) that returns a hardcoded
   `Task[]` (no HTTP) via a signal or a plain method.
3. `TaskListComponent` injects `TaskMockService`, renders the list with
   `@for`, and shows a checkmark or strikethrough for `done` tasks.
4. Add a "toggle done" button per task using `@Output()` to notify a parent,
   or handle it locally with a signal — either is fine, the point is
   practicing `@Input`/`@Output`/signals.
5. Confirm it renders and updates in the browser at `localhost:4200`
   (still no real backend call yet).

**Done when:** you can render a list, toggle a task's done state in the UI,
and explain what a signal is doing differently from a plain class field.

Next: [Module 9 — Connecting Angular to Spring Boot](09-angular-backend-integration.md)
