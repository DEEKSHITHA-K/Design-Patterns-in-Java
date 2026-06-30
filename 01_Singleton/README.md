# Singleton Pattern

## What this code is doing
This example uses one shared object for the whole application. The class keeps a single instance in memory and gives every part of the program the same object.

## Why this pattern is used
Use Singleton when you want one global manager, such as a logger, configuration holder, or connection pool. It prevents multiple copies from being created accidentally.

## Key Java ideas for beginners
- `private static Logger instance;` stores the single object.
- `private Logger()` blocks outside code from creating a new object.
- `public static Logger getInstance()` is the only way to access the object.
- `if (instance == null)` creates the object only once.

## Real-life analogy
Think of it as having one office receptionist for the whole company instead of many separate receptionists.


## Difference from similar patterns
Unlike Factory Method, this pattern does not create different objects; it controls access to one object.