# Module 5 — Relationships & Richer Domain Modeling

## Goal

Model a real one-to-many relationship, and learn why returning JPA entities
directly from a controller is a bad habit.

## Key concepts

- `@ManyToOne` / `@OneToMany` — a `Category` has many `Task`s, a `Task`
  belongs to one `Category`
- Why entities and API responses shouldn't always be the same class (DTOs):
  avoiding infinite JSON recursion, hiding internal fields, controlling
  exactly what the client sees
- Nested JSON in a response body

## Exercise

1. Create a `Category` entity (`id`, `name`) and
   `CategoryRepository extends JpaRepository<Category, Long>`.
2. Add a `@ManyToOne` `category` field to `Task` (nullable — a task doesn't
   have to have a category).
3. Add `com.learning.tasktracker.controller.CategoryController` with
   `POST /api/categories` and `GET /api/categories`.
4. Introduce a `TaskResponse` DTO (id, title, done, categoryId,
   categoryName) that `TaskController` returns instead of the raw `Task`
   entity — write a small mapper method (plain Java, no library needed yet)
   converting `Task` → `TaskResponse`.
5. Add `GET /api/tasks?categoryId={id}` to filter tasks by category (Spring
   Data JPA method name query, e.g. `findByCategoryId(Long categoryId)`).

**Done when:** you can create a category, create tasks under it, and filter
tasks by category — and you can explain in your own words why
`TaskController` no longer returns the `Task` entity directly.

Next: [Module 6 — Validation & Error Handling](06-validation.md)
