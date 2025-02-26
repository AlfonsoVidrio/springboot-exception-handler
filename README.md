# Spring Boot Error Handling

A Spring Boot application that demonstrates custom error handling, exception management, and user-related services. The application provides basic user management and error handling for various exceptions, including `ArithmeticException`, `NoHandlerFoundException`, `NullPointerException`, `UserNotFoundException`, and `NumberFormatException`.

## Features

- **Custom Exception Handling**: Handles different types of exceptions and returns structured error responses.
- **User Service**: A mock user service with predefined users, which allows searching for users by ID.
- **Error Responses**: Custom error messages with HTTP status codes and timestamp.
- **Demo Endpoint**: A simple endpoint to test error scenarios.

## API Endpoints

### `GET /app`

```bash
http://localhost:8080/app
```

### `GET /app/show/{id}`

```bash
http://localhost:8080/app/show/{id}
```
