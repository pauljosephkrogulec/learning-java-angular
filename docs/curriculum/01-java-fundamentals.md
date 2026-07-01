# Module 1 — Java Fundamentals Refresher

## Goal

Get comfortable with plain Java — no Spring, no framework "magic" — so that
when Spring Boot starts doing things automatically in Module 2, you can tell
what's Java and what's the framework.

## Key concepts

- Variables, primitive types, `String`
- Control flow: `if`/`else`, `for`, `while`, `switch`
- Methods: parameters, return types
- Classes and objects: fields, constructors, methods
- Interfaces (just enough to understand `List` in the next point)
- Collections: `ArrayList`, `List`, `Map`
- Basic encapsulation (private fields + public getters/setters)

## Exercise

Write a plain Java console app (a new file, e.g.
`backend/src/main/java/com/learning/tasktracker/scratch/TaskConsoleApp.java`,
run with `java` directly or `mvn -q compile exec:java` — not through Spring)
that:

1. Defines a `Task` class with fields: `id` (int), `title` (String), `done`
   (boolean).
2. Keeps an `ArrayList<Task>` in memory.
3. Reads commands from `Scanner` in a loop:
   - `add <title>` — adds a new task
   - `list` — prints all tasks, showing `done` status
   - `done <id>` — marks a task complete
   - `remove <id>` — removes a task
   - `quit` — exits

**Done when:** you can add, list, complete, and remove tasks in a running
terminal session, entirely with plain Java.

Next: [Module 2 — Spring Boot Basics](02-spring-boot-basics.md)
