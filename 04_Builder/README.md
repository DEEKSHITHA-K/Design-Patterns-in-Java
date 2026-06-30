# Builder Pattern

## What this code is doing
The code builds a complex object step by step. Instead of passing many constructor parameters, the builder helps set values one by one.

## Why this pattern is used
Use Builder when an object has many optional fields or when the construction logic is long and confusing.

## Key Java ideas for beginners
- `User.Builder` collects values gradually.
- Each setter method returns the builder itself, so methods can be chained.
- `build()` creates the final object.

## Real-life analogy
It is like assembling a custom pizza one topping at a time instead of trying to fit everything into one giant constructor.


## Difference from similar patterns
Unlike Factory Method, this pattern focuses on constructing a complex object with many options.