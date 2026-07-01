# Module 6 — Validation & Error Handling

## Goal

Reject bad input with a clear, consistent error response instead of
crashing, corrupting data, or returning a confusing 500.

## Key concepts

- Bean Validation annotations: `@NotBlank`, `@Size`, `@PastOrPresent` /
  `@Future`
- `@Valid` on a controller's `@RequestBody` parameter
- `@RestControllerAdvice` + `@ExceptionHandler` — one place to turn
  exceptions into a consistent JSON error shape
- The difference between a validation error (client's fault, 400) and a
  server error (your fault, 500)

## Exercise

1. Introduce a request DTO for creating/updating tasks (e.g.
   `TaskRequest` with `title`, `dueDate`, `priority`), separate from the
   `TaskResponse` DTO from Module 5.
2. Add validation annotations:
   - `title`: `@NotBlank`
   - `dueDate`: must not be in the past (`@FutureOrPresent`, if present)
   - `priority`: an enum (`LOW`, `MEDIUM`, `HIGH`) — invalid values should
     already fail to deserialize; make sure that also produces a clean 400
3. Add `@Valid` to the `POST`/`PUT` endpoints.
4. Create `com.learning.tasktracker.web.GlobalExceptionHandler` annotated
   `@RestControllerAdvice`, handling `MethodArgumentNotValidException` and
   returning a structured body, e.g.:
   ```json
   {
     "status": 400,
     "errors": [
       { "field": "title", "message": "must not be blank" }
     ]
   }
   ```
5. Update your saved Postman/`.http` collection (from Module 3) with a few
   "bad input" requests demonstrating each validation rule failing cleanly.

**Done when:** sending a blank title or a past due date returns a `400`
with a field-level error message, not a stack trace or a `500`.

Next: [Module 7 — Backend Testing](07-backend-testing.md)
