# Module 2 — Spring Boot Basics

## Goal

Understand what Spring Boot actually does for you: it starts a web server,
manages object creation for you (dependency injection), and lets you expose
Java methods as HTTP endpoints.

## Key concepts

- The generated project layout (`pom.xml`, `TasktrackerApplication.java`)
- `@SpringBootApplication` and what happens when `main()` runs
- The IoC container: Spring creates and wires up your objects ("beans") for
  you instead of you calling `new` everywhere
- Constructor injection (`@Autowired` is implicit with a single constructor)
- `@RestController` and `@GetMapping`

## Exercise

1. Create `com.learning.tasktracker.service.TaskService` — a plain
   `@Service` class with a hardcoded `List<String>` of task titles and a
   method `getAllTasks()`.
2. Create `com.learning.tasktracker.controller.TaskController` — a
   `@RestController` that takes `TaskService` in its constructor and exposes:
   - `GET /api/tasks` → returns the list from `TaskService`
3. Run the stack (`docker compose up`) and verify in a browser or with curl:
   ```
   curl http://localhost:8080/api/tasks
   ```

**Done when:** the endpoint returns your hardcoded list as JSON, and you can
explain in your own words what `@RestController` and constructor injection
are doing.

Next: [Module 3 — REST API + In-Memory CRUD](03-rest-crud.md)
