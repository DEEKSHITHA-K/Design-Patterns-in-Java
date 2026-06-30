# Chain of Responsibility Pattern

## What this code is doing
A request moves through a chain of handlers. Each handler decides whether it can process the request or pass it along.

## Why this pattern is used
Use this pattern when several handlers may be able to process a request and you want to avoid hard-coding the decision logic in one place.

## Key Java ideas for beginners
- `Handler` holds a reference to the next handler.
- `canHandle()` decides whether this handler should process the request.
- `handleRequest()` passes the request forward if needed.

## Real-life analogy
It is like passing a task to the next suitable person until someone can complete it.


## Difference from similar patterns
Unlike Command, this pattern passes a request through a chain instead of wrapping one action as an object.