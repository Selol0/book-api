# Book API

A simple REST API built with Spring Boot. Books are stored in memory
(database integration is planned as the next step).

## Endpoints

| Method | URL | Description | Success status |
|---|---|---|---|
| GET | `/books` | List all books | 200 |
| GET | `/books/{id}` | Get a book by id (404 if not found) | 200 |
| POST | `/books` | Add a new book | 201 |

## Example request

POST `/books`
```json
{"title": "The Alchemist", "author": "Paulo Coelho"}
```

## Run
Requires Java 21 or higher.

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`.

## Concepts Covered
- REST API design, HTTP methods and status codes
- `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`
- `@RequestBody` and `@PathVariable`
- `ResponseEntity` for controlling status codes