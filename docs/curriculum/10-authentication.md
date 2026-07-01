# Module 10 — Authentication & Authorization

## Goal

Add real login, and make sure a user can only see and edit their own tasks.
This is the first module where Spring Security enters the project — it was
deliberately left out until now so you weren't fighting default login
screens while learning everything else.

## Key concepts

- Spring Security basics: what it locks down by default once added
- Password hashing with `BCrypt` — never store plain-text passwords
- JWT (JSON Web Tokens): issuing a token on login, validating it on
  subsequent requests
- Securing endpoints by role/ownership (a user can only touch their own
  tasks)
- On the Angular side: a login form, storing the JWT, an `HttpInterceptor`
  that attaches it to outgoing requests, and route guards that redirect
  unauthenticated users to `/login`

## Exercise

1. Add `spring-boot-starter-security` and a JWT library to `backend/pom.xml`.
2. Create a `User` entity (`id`, `username`, `passwordHash`), a
   `Task.owner` (`@ManyToOne User`, non-null now), and a
   `AuthController` with `POST /api/auth/register` and `POST
   /api/auth/login` (returns a JWT).
3. Configure Spring Security so all `/api/tasks/**` and `/api/categories/**`
   endpoints require a valid JWT, and `TaskController` only ever
   reads/writes tasks owned by the authenticated user.
4. Frontend: add login/register pages, an `AuthService` storing the token
   (e.g. in memory + `localStorage`), an `HttpInterceptor` adding
   `Authorization: Bearer <token>` to every API call, and a route guard
   protecting the task pages.
5. Verify: log in as two different users, confirm each only ever sees their
   own tasks, and confirm an expired/missing token redirects cleanly to
   `/login` instead of showing a broken page.

**Done when:** two separate user accounts each see only their own tasks, and
there's no way to view another user's data by guessing an ID.

Next: [Module 11 — Frontend Testing](11-frontend-testing.md)
